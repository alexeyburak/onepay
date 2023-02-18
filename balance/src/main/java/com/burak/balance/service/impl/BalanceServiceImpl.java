package com.burak.balance.service.impl;

import com.burak.balance.dto.UserDTO;
import com.burak.balance.service.BalanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.retry.Retry;

import java.math.BigDecimal;
import java.time.Duration;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {
    private static final String USER_MODULE_URI = "http://localhost:6000/api/users/";
    private final WebClient webClient;

    @Override
    public BigDecimal getUserBalance(long userId) {
        return webClient.get()
                .uri(USER_MODULE_URI + userId)
                .retrieve()
                .bodyToMono(UserDTO.class)
                .retryWhen(Retry.fixedDelay(3, Duration.ofMillis(100)))
                .map(UserDTO::getBalance)
                .block();
    }
}
