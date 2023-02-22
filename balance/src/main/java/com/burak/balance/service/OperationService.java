package com.burak.balance.service;

import com.burak.balance.dto.CommitOperationDTO;
import com.burak.balance.dto.OperationHistoryDTO;

import java.time.LocalDate;
import java.util.List;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

public interface OperationService {
    List<OperationHistoryDTO> getUserOperationHistory(Long id, LocalDate dateFrom);
    void commitOperation(CommitOperationDTO operation);
}
