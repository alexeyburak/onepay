package com.burak.user.service;

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

import java.util.List;

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
}
