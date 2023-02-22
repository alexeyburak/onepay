package com.burak.balance.controller;

import com.burak.balance.dto.OperationHistoryDTO;
import com.burak.balance.service.impl.OperationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/operations")
public class OperationController {
    private final OperationServiceImpl operationService;

    @GetMapping("/user/{id}")
    public ResponseEntity<List<OperationHistoryDTO>> getUserOperationHistory(@PathVariable Long id,
                                                                             @RequestParam(name = "dateFrom", required = false)
                                                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFrom) {
        List<OperationHistoryDTO> operations = operationService.getUserOperationHistory(id, dateFrom);
        return new ResponseEntity<>(operations, HttpStatus.OK);
    }
}
