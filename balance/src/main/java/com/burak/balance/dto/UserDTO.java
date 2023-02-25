package com.burak.balance.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    long id;
    String name;
    String surname;
    String email;
    String password;
    BigDecimal balance;
    LocalDateTime joinedAt;
}
