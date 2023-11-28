package com.group3.omniserve.omniserve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group3.omniserve.omniserve.models.User;
import com.group3.omniserve.omniserve.services.UsersService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UsersService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(User user) {
        return userService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id,User user) {
        return userService.updateUser(id, user);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
        return userService.deleteUser(id);
    }
}
