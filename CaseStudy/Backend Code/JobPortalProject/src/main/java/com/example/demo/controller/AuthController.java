package com.example.demo.controller;

import com.example.demo.config.JwtService;


import com.example.demo.model.User;

import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class AuthController {

    
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

   

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (userService.existsByUsername(user.getUsername())) {
            return "Username already taken!";
        }
        if (userService.existsByEmail(user.getEmail())) {
            return "Email already registered!";
        }

        // Set email as username if username not provided
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            user.setUsername(user.getEmail());
            
        }
     // Set email as username if username not provided
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            user.setUsername(user.getEmail());
        }

        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwtToken = jwtService.generateToken(userDetails);

        return jwtToken;
    }
}
