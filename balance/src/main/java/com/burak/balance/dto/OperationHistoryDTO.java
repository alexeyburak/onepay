package com.burak.balance.dto;

import com.burak.balance.model.enums.OperationStatus;
import com.burak.balance.model.enums.OperationType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperationHistoryDTO {
    long id;
    BigDecimal sum;
    LocalDate dateCreatedAt;
    LocalTime timeCreatedAt;
    OperationType type;
    OperationStatus status;
}
