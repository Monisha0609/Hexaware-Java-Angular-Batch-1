package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employers;
import com.example.demo.model.Users;
import com.example.demo.repo.EmployerRepository;
import com.example.demo.repo.UserRepository;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepo;

    @Autowired
    private UserRepository userRepo;

    public List<Employers> showEmployers() {
        return employerRepo.findAll();
    }

    public int authenticate(String username, String password) {
        Users user = userRepo.findByUsernameAndPassword(username, password);
        if (user != null && "Employer".equalsIgnoreCase(user.getRole())) {
            return 1;
        }
        return 0;
    }

    public ResponseEntity<Employers> searchByEmployerId(int employerId) {
        Employers employer = employerRepo.findById(employerId)
                .orElseThrow(() -> new ResourceNotFoundException("Employer with ID " + employerId + " not found"));
        return new ResponseEntity<>(employer, HttpStatus.OK);
    }

    public ResponseEntity<Employers> searchByCompanyName(String companyName) {
        Employers employer = employerRepo.findByCompanyName(companyName);
        if (employer != null) {
            return new ResponseEntity<>(employer, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Employer with company name " + companyName + " not found");
        }
    }
}
