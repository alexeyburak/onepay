package com.burak.notification.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    String name;
    String surname;
    String email;
    LocalDateTime joinedAt;
}
