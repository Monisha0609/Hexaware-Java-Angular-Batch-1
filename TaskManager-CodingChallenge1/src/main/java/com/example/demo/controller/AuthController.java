package com.example.demo.controller;

import com.example.demo.config.JwtUtil;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome! This endpoint is not secured.";
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        service.saveUser(user);
        return "User registered successfully!";
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody User user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );

            if (authentication.isAuthenticated()) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
                return jwtUtil.generateToken(userDetails);
            } else {
                throw new UsernameNotFoundException("Invalid user request!");
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException("Authentication failed: " + e.getMessage());
        }
    }

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('User')")
    public String userProfile() {
        return "Welcome to User Profile!";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('Admin')")
    public String adminProfile() {
        return "Welcome to Admin Profile!";
    }
}
