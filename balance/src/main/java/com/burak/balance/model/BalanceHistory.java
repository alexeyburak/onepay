package com.burak.balance.model;

import com.burak.balance.model.enums.OperationType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
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
@Table(name = "balance_history")
public class BalanceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "user_Id")
    Long userId;
    @Column(name = "bank_Number")
    Long bankNumber;
    @Column(name = "sum")
    BigDecimal sum;
    @Column(name = "date_Crated_At")
    LocalDate dateCreatedAt;
    @Column(name = "time_Crated_At")
    LocalTime timeCreatedAt;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    OperationType type;

    @PrePersist
    void initialize() {
        sum = BigDecimal.valueOf(0L);
        dateCreatedAt = LocalDate.now();
        timeCreatedAt = LocalTime.now();
    }

}
