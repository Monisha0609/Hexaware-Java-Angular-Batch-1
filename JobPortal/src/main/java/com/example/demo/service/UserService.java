package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Users;
import com.example.demo.repo.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<Users> showUsers() {
        return userRepo.findAll();
    }

    public int authenticate(String username, String password) {
        Users user = userRepo.findByUsernameAndPassword(username, password);
        return (user != null) ? 1 : 0;
    }

    public ResponseEntity<Users> searchByUserId(int userId) {
        Users user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + userId + " not found"));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<Users> searchByUsername(String username) {
        Users user = userRepo.findByUsername(username);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("User with username " + username + " not found");
        }
    }
}
