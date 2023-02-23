package com.burak.balance.service.impl;

import com.burak.balance.dto.CommitOperationDTO;
import com.burak.balance.dto.OperationHistoryDTO;
import com.burak.balance.exception.OperationNotFoundException;
import com.burak.balance.model.OperationHistory;
import com.burak.balance.repository.OperationRepository;
import com.burak.balance.service.OperationService;
import com.burak.balance.service.mapper.OperationHistoryDTOMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

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
    private final OperationHistoryDTOMapper historyDTOMapper;

    @Override
    public OperationHistory getOperationHistoryById(long id) {
        return operationRepository.findById(id)
                .orElseThrow(() -> new OperationNotFoundException("Operation not found. Id: " + id));
    }

    @Override
    public List<OperationHistoryDTO> getUserOperationHistory(Long id, LocalDate dateFrom) {
        Stream<OperationHistoryDTO> operations = operationRepository
                .getOperationHistoriesByUserId(id)
                .stream()
                .map(historyDTOMapper);

        return dateFrom != null ?
                operations
                        .filter(operation -> operation.getDateCreatedAt().isAfter(dateFrom))
                        .toList() :
                operations
                        .toList();
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

    @Override
    public void deleteById(long id) {
        operationRepository.deleteById(id);
        log.info("Delete operation. Id: {}", id);
    }
}
