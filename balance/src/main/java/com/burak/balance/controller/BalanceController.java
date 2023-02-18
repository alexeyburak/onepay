package com.burak.balance.controller;

import com.burak.balance.service.impl.BalanceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/balances")
public class BalanceController {

    private final BalanceServiceImpl balanceService;

    @GetMapping("/{userId}")
    public ResponseEntity<BigDecimal> getUserBalance(@PathVariable("userId") long userId) {
        BigDecimal balance = balanceService.getUserBalance(userId);
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }

}
