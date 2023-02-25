package com.burak.user.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

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
public class UserDTO {
    String name;
    String surname;
    String email;
    String password;
}
