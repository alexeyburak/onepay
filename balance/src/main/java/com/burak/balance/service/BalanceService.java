package com.burak.balance.service;

import java.math.BigDecimal;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

public interface BalanceService {
    BigDecimal getUserBalance(long userId);
    boolean debitingFundsFromBankAccount(long userId, BigDecimal sum);
    void entranceFundsToBankAccount(long userId, BigDecimal sum);
    void setNewBalanceForUserClient(long id, BigDecimal newBalance);
}
