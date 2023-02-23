package com.burak.balance.service;

import com.burak.balance.dto.CommitOperationDTO;
import com.burak.balance.dto.OperationHistoryDTO;
import com.burak.balance.model.OperationHistory;

import java.time.LocalDate;
import java.util.List;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

public interface OperationService {
    OperationHistory getOperationHistoryById(long id);
    List<OperationHistoryDTO> getUserOperationHistory(Long id, LocalDate dateFrom);
    void commitOperation(CommitOperationDTO operation);
    void deleteById(long id);
}
