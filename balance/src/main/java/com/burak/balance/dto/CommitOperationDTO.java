package com.burak.balance.dto;

import com.burak.balance.model.enums.OperationStatus;
import com.burak.balance.model.enums.OperationType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

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
public class CommitOperationDTO {
    long userId;
    BigDecimal sum;
    OperationType type;
    OperationStatus status;
}
