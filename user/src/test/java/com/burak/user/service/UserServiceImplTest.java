package com.burak.user.service;

import com.burak.user.dto.UserDTO;
import com.burak.user.model.User;
import com.burak.user.repository.UserRepository;
import com.burak.user.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void getAllUsers_ShouldReturnUserListFromRepository() {
        //given
        List<User> users = List.of(
                User.builder().build(),
                User.builder().build(),
                User.builder().build()
        );

        //when
        Mockito.when(userRepository.findAll()).thenReturn(users);
        List<User> result = userService.getAllUsers();

        //then
        Assertions.assertNotNull(result);
        Assertions.assertEquals(users.size(), result.size());
        Assertions.assertEquals(users, result);
    }

    @Test
    void updateById_UserIdAndUpdatedUser_ShouldUpdateUserAndSave() {
        //given
        final long id = 1L;
        UserDTO updatedUser = UserDTO.builder()
                .name("Alexey")
                .surname("Burak")
                .password("password")
                .build();
        User user = User.builder().build();

        //when
        Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(user));
        userService.updateById(id, updatedUser);

        //then
        Assertions.assertNotNull(user);
        Assertions.assertEquals(user.getName(), updatedUser.getName());
        Assertions.assertEquals(user.getSurname(), updatedUser.getSurname());
        Assertions.assertEquals(user.getPassword(), updatedUser.getPassword());
    }

    @Test
    void updateBalanceById_UserIdAndChangedBalance_ShouldSetNewBalanceAndSave() {
        //given
        final long userId = 1L;
        User user = User.builder()
                .id(userId)
                .balance(BigDecimal.valueOf(100))
                .build();
        BigDecimal updatedBalance = BigDecimal.valueOf(1000);

        //when
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        userService.updateBalanceById(userId, updatedBalance);

        //then
        Assertions.assertNotNull(user);
        Assertions.assertNotNull(user.getBalance());
        Assertions.assertEquals(user.getBalance(), updatedBalance);
    }

    @Test
    void deleteById_UserId_ShouldDeleteUserEntity() {
        //given
        final long userId = 1L;
        User user = User.builder().build();

        //when
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        userService.deleteById(userId);

        //then
        Mockito.verify(userRepository, Mockito.times(1)).delete(user);
    }
}
