package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;

import com.example.demo.repo.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;

@Component
public class EncryptPasswordRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        for (User user : userRepository.findAll()) {
            String currentPassword = user.getPassword();

            // Only encrypt if not already encoded
            if (!currentPassword.startsWith("$2a$")) {
                user.setPassword(passwordEncoder.encode(currentPassword));
                userRepository.save(user);
                System.out.println("✅ Encrypted password for user: " + user.getUsername());
            }
        }

        System.out.println("✅ All passwords checked and updated if necessary.");
    }
}
