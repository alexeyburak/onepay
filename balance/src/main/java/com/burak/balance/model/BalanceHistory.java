package com.burak.balance.model;

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
    LocalDate dateCratedAt;
    @Column(name = "time_Crated_At")
    LocalTime timeCratedAt;

}
