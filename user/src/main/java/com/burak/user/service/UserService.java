package com.burak.user.service;

import com.burak.user.dto.UserDTO;
import com.burak.user.model.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    void addNewUser(UserDTO user);
    void deleteById(Long id);
    void updateById(Long id, UserDTO updatedUser);
    void updateBalanceById(Long id, BigDecimal balance);
}
