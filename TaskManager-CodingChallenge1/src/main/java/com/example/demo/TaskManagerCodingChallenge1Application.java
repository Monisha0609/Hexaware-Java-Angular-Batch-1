package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TaskManagerCodingChallenge1Application {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerCodingChallenge1Application.class, args);
    }

    
    @Bean
    public CommandLineRunner runner(UserRepository userRepo, PasswordEncoder encoder) {
        return args -> {
            userRepo.findAll().forEach(user -> {
                if (user.getPassword() != null && !user.getPassword().startsWith("$2a$")) {
                    
                    user.setPassword(encoder.encode(user.getPassword()));
                    userRepo.save(user);
                    System.out.println("✅ Password encoded for user: " + user.getUsername());
                }
            });
        };
    }
}
