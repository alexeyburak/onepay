package com.burak.user.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    String name;
    String password;
    String surname;
}
