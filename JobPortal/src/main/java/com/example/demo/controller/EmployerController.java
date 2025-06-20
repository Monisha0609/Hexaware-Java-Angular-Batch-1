package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Employers;
import com.example.demo.service.EmployerService;

@RestController
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @GetMapping("/showEmployers")
    public List<Employers> showEmployers() {
        return employerService.showEmployers();
    }

    @GetMapping("/employerLogin/{username}/{password}")
    public String loginEmployer(@PathVariable String username, @PathVariable String password) {
        int result = employerService.authenticate(username, password);
        return String.valueOf(result);
    }

    @GetMapping("/searchEmployerById/{employerId}")
    public ResponseEntity<Employers> searchEmployerById(@PathVariable int employerId) {
        return employerService.searchByEmployerId(employerId);
    }

    @GetMapping("/searchEmployerByCompany/{companyName}")
    public ResponseEntity<Employers> searchEmployerByCompany(@PathVariable String companyName) {
        return employerService.searchByCompanyName(companyName);
    }
}
