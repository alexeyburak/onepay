package com.burak.user.controller;

import com.burak.user.dto.UserDTO;
import com.burak.user.model.User;
import com.burak.user.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addNewUser(@RequestBody UserDTO user) {
        userService.addNewUser(user);
        return new ResponseEntity<>("Add new user.", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("Delete user.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id,
                                             @RequestBody UserDTO user) {
        userService.updateById(id, user);
        return ResponseEntity.ok("Update user.");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> changeBalance(@PathVariable("id") Long id,
                                                @RequestParam("newBalance") BigDecimal balance) {
        userService.updateBalanceById(id, balance);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
