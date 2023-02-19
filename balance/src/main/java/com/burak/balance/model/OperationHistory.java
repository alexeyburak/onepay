package com.burak.balance.model;

import com.burak.balance.model.enums.OperationStatus;
import com.burak.balance.model.enums.OperationType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "operation_history")
@Getter
@Setter
public class OperationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "user_Id")
    Long userId;
    @Column(name = "sum")
    BigDecimal sum;
    @Column(name = "date_Crated_At")
    LocalDate dateCreatedAt;
    @Column(name = "time_Crated_At")
    LocalTime timeCreatedAt;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    OperationType type;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    OperationStatus status;

    @PrePersist
    void initialize() {
        dateCreatedAt = LocalDate.now();
        timeCreatedAt = LocalTime.now();
    }

}
