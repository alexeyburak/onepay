package com.burak.balance.controller;

import com.burak.balance.service.impl.BalanceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{userId}/deb")
    public ResponseEntity<String> debitingFromUserBalance(@PathVariable("userId") long userId,
                                                          @RequestParam("sum") BigDecimal sum) {
        boolean changingUserBalance = balanceService.debitingFundsFromBankAccount(userId, sum);

        return changingUserBalance ?
                new ResponseEntity<>("Successfully debiting.", HttpStatus.OK) :
                new ResponseEntity<>("Error debiting.", HttpStatus.LOCKED);

    }

    @PostMapping("/{userId}/ent")
    public ResponseEntity<String> entranceToUserBalance(@PathVariable("userId") long userId,
                                                        @RequestParam("sum") BigDecimal sum) {
        balanceService.entranceFundsToBankAccount(userId, sum);
        return ResponseEntity.ok("Successfully entrance " + sum);
    }

}
