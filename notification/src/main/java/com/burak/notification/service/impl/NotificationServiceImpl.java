package com.burak.notification.service.impl;

import com.burak.notification.dto.UserDTO;
import com.burak.notification.model.EmailType;
import com.burak.notification.service.AbstractMailSender;
import com.burak.notification.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.retry.Retry;

import java.time.Duration;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

@Service
@Slf4j
public class NotificationServiceImpl extends AbstractMailSender implements NotificationService {
    private static final String USER_MODULE_URI = "http://localhost:6000/api/users/";
    private final WebClient webClient;

    public NotificationServiceImpl(JavaMailSender mailSender, WebClient webClient) {
        super(mailSender);
        this.webClient = webClient;
    }

    @Override
    public void sendNotification(long userId, EmailType type) {
        final UserDTO user = this.getUserDTO(userId);

        switch (type) {
            case GREETING -> greetingEmail(user);
            case CHANGE_PASSWORD -> changePasswordEmail(user);
            case DAILY ->dailyEmail(user);
        }
    }

    private UserDTO getUserDTO(long userId) {
        return webClient.get()
                .uri(USER_MODULE_URI + userId)
                .retrieve()
                .bodyToMono(UserDTO.class)
                .retryWhen(Retry.fixedDelay(3, Duration.ofMillis(100)))
                .block();
    }

    @Override
    public void greetingEmail(UserDTO user) {
        title = "Thanks for registration!";
        message = String.format(
                """
                    Dear %s %s, you successfully registered on our app at %s.
                    
                """,
                user.getName(),
                user.getSurname(),
                user.getJoinedAt()
        );

        sendWithMime(user.getEmail(), title, message);
    }

    @Override
    public void changePasswordEmail(UserDTO user) {
        title = "You successfully change password!";
        message = String.format(
                """
                    Dear %s %s, you successfully change password.
                    
                """,
                user.getName(),
                user.getSurname()
        );

        sendWithMime(user.getEmail(), title, message);
    }

    @Override
    public void dailyEmail(UserDTO user) {
        title = "Don't forget us!";
        message = String.format(
                """
                    Dear %s %s, don't forget us, visit our website.
                """,
                user.getName(),
                user.getSurname()
        );

        sendWithMime(user.getEmail(), title, message);
    }
}
