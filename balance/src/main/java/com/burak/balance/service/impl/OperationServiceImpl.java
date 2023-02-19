package com.burak.balance.service.impl;

import com.burak.balance.dto.CommitOperationDTO;
import com.burak.balance.model.OperationHistory;
import com.burak.balance.model.enums.OperationType;
import com.burak.balance.repository.OperationRepository;
import com.burak.balance.service.OperationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {

    private final OperationRepository operationRepository;

    @Override
    public List<OperationHistory> getUserOperationHistory(Long id) {
        return operationRepository.getOperationHistoriesByUserId(id);
    }

    @Override
    public void commitOperation(CommitOperationDTO operation) {
        long userId = operation.getUserId();

        operationRepository.save(
                OperationHistory.builder()
                        .userId(userId)
                        .sum(operation.getSum())
                        .type(operation.getType())
                        .status(operation.getStatus())
                        .build()
        );
        log.info("Commit operation. User id: {}", userId);
    }
}
