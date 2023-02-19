package com.burak.balance.controller;

import com.burak.balance.model.OperationHistory;
import com.burak.balance.service.impl.OperationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<OperationHistory>> getUserOperationHistory(@PathVariable Long id) {
        List<OperationHistory> operations = operationService.getUserOperationHistory(id);
        return new ResponseEntity<>(operations, HttpStatus.OK);
    }
}
