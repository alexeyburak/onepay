package com.burak.balance.service.impl;

import com.burak.balance.dto.CommitOperationDTO;
import com.burak.balance.dto.UserDTO;
import com.burak.balance.model.enums.OperationStatus;
import com.burak.balance.model.enums.OperationType;
import com.burak.balance.service.BalanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
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
    private final OperationServiceImpl operationService;
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

    @Override
    public boolean debitingFundsFromBankAccount(long userId, BigDecimal sum) {
        BigDecimal balance = getUserBalance(userId);
        if (!isEnoughMoney(balance, sum))
            return false;

        BigDecimal newBalance = subtractBalance(balance, sum);
        setNewBalanceForUserClient(userId, newBalance);

        operationService.commitOperation(
                CommitOperationDTO.builder()
                        .userId(userId)
                        .sum(sum)
                        .type(OperationType.DEBITING)
                        .status(OperationStatus.SUCCESSFUL)
                        .build()
        );
        log.info("Debiting funds. User id: {}", userId);
        return true;
    }

    private boolean isEnoughMoney(BigDecimal balance, BigDecimal sum) {
        return balance.compareTo(sum) >= 0;
    }

    private BigDecimal subtractBalance(BigDecimal balance, BigDecimal sum) {
        return balance.subtract(sum);
    }

    @Override
    public void entranceFundsToBankAccount(long userId, BigDecimal sum) {
        BigDecimal newBalance = getUserBalance(userId).add(sum);

        setNewBalanceForUserClient(userId, newBalance);
        operationService.commitOperation(CommitOperationDTO.builder()
                .userId(userId)
                .sum(sum)
                .type(OperationType.DEBITING)
                .status(OperationStatus.SUCCESSFUL)
                .build());
        log.info("Entrance funds. User id: {}", userId);
    }

    @Override
    public void setNewBalanceForUserClient(long id, BigDecimal newBalance) {
        webClient.patch()
                .uri(USER_MODULE_URI + id)
                .body(BodyInserters.fromFormData("newBalance", String.valueOf(newBalance)))
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(System.out::println);
    }
}
