package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Users;
import com.example.demo.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/showUsers")
    public List<Users> showUsers() {
        return userService.showUsers();
    }

    @GetMapping("/userLogin/{username}/{password}")
    public String loginUser(@PathVariable String username, @PathVariable String password) {
        int result = userService.authenticate(username, password);
        return String.valueOf(result);
    }

    @GetMapping("/searchUserById/{userId}")
    public ResponseEntity<Users> searchUserById(@PathVariable int userId) {
        return userService.searchByUserId(userId);
    }

    @GetMapping("/searchUserByUsername/{username}")
    public ResponseEntity<Users> searchUserByUsername(@PathVariable String username) {
        return userService.searchByUsername(username);
    }
}
