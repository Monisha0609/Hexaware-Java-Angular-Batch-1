package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;


@EnableMethodSecurity(prePostEnabled = true)
@SpringBootApplication
public class JobPortalProject3Application {

	public static void main(String[] args) {
		SpringApplication.run(JobPortalProject3Application.class, args);
	}

}
