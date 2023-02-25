package com.burak.notification.service.impl;

import com.burak.notification.model.EmailType;
import com.burak.notification.service.AbstractMailSender;
import com.burak.notification.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

@Service
@Slf4j
public class NotificationServiceImpl extends AbstractMailSender implements NotificationService {
    public NotificationServiceImpl(JavaMailSender mailSender) {
        super(mailSender);
    }

    @Override
    public void sendNotification(Long userId, EmailType type) {
        switch (type) {
            case GREETING -> greetingEmail(userId, type);
        }
    }

    @Override
    public void greetingEmail(long userId, EmailType type) {
        title = "title";
        message = "<h3>mess</h3>";
    }
}
