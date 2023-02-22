package com.burak.balance.service.mapper;

import com.burak.balance.dto.OperationHistoryDTO;
import com.burak.balance.model.OperationHistory;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

@Service
public class OperationHistoryDTOMapper implements Function<OperationHistory, OperationHistoryDTO> {
    @Override
    public OperationHistoryDTO apply(OperationHistory operationHistory) {
        return OperationHistoryDTO.builder()
                .sum(operationHistory.getSum())
                .dateCreatedAt(operationHistory.getDateCreatedAt())
                .timeCreatedAt(operationHistory.getTimeCreatedAt())
                .type(operationHistory.getType())
                .status(operationHistory.getStatus())
                .build();
    }
}
