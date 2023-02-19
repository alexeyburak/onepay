package com.burak.balance.repository;

import com.burak.balance.model.OperationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

@Repository
public interface OperationRepository extends JpaRepository<OperationHistory, Long> {
    List<OperationHistory> getOperationHistoriesByUserId(Long userId);
}
