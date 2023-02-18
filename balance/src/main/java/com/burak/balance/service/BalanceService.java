package com.burak.balance.service;

import java.math.BigDecimal;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

public interface BalanceService {
    BigDecimal getUserBalance(long userId);
}
