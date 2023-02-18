package com.burak.balance.service;

import com.burak.balance.model.OperationHistory;

import java.util.List;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

public interface OperationService {
    List<OperationHistory> getUserOperationHistory(Long id);
}
