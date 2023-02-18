package com.burak.user.service.impl;

import com.burak.user.dto.UserDTO;
import com.burak.user.exception.UserNotFoundException;
import com.burak.user.model.User;
import com.burak.user.repository.UserRepository;
import com.burak.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public void addNewUser(UserDTO user) {
        User userToSave = User.builder()
                .name(user.getName())
                .password(user.getPassword())
                .joinedAt(LocalDateTime.now())
                .build();

        userRepository.saveAndFlush(userToSave);
        log.info("Add new user. Id: {}", userToSave.getId());
    }

    @Override
    public void deleteById(Long id) {
        User user = this.getUserById(id);

        userRepository.delete(user);
        log.info("Delete user. Id: {}", id);
    }

    @Override
    public void updateById(Long id, UserDTO updatedUser) {
        User user = this.getUserById(id);

        user.setName(updatedUser.getName());
        user.setPassword(updatedUser.getPassword());

        userRepository.save(user);
        log.info("Update user. Id: {}", id);
    }

    @Override
    public void updateBalanceById(Long id, BigDecimal balance) {
        User user = this.getUserById(id);
        user.setBalance(balance);

        userRepository.save(user);
        log.info("Change balance. User id: {}", id);
    }
}
