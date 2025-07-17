package com.example.demo.controller;

import com.example.demo.model.Employer;
import com.example.demo.service.EmployerService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employer")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class EmployerController {

    private final EmployerService employerService;


    @PostMapping("/create")
    @PreAuthorize("hasRole('EMPLOYER')")
    public Employer create(@RequestBody Employer employer) {
        return employerService.createEmployer(employer);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('EMPLOYER')")
    public List<Employer> getAll() {
        return employerService.getAllEmployers();
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('EMPLOYER')")
    public List<Employer> getByUserId(@PathVariable Integer userId) {
        return employerService.getEmployersByUserId(userId);
    }

    @PutMapping("/{employerId}")
    @PreAuthorize("hasRole('EMPLOYER')")
    public Employer update(@PathVariable Integer employerId, @RequestBody Employer employer) {
        return employerService.updateEmployer(employerId, employer);
    }

    @DeleteMapping("/{employerId}")
    @PreAuthorize("hasRole('EMPLOYER')")
    public void delete(@PathVariable Integer employerId) {
        employerService.deleteEmployer(employerId);
    }
}
