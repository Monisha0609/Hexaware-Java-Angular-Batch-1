package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employer;
import com.example.demo.repo.EmployerRepository;

import java.util.List;

@Service

public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    public Employer createEmployer(Employer employer) {
        return employerRepository.save(employer);
    }

    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }

    public List<Employer> getEmployersByUserId(Integer userId) {
        return employerRepository.findByUserUserId(userId);
    }

    public Employer updateEmployer(Integer id, Employer updatedEmployer) {
        Employer existing = employerRepository.findById(id).orElseThrow();
        existing.setCompanyName(updatedEmployer.getCompanyName());
        existing.setContactNumber(updatedEmployer.getContactNumber());
        existing.setLocation(updatedEmployer.getLocation());
        return employerRepository.save(existing);
    }

    public void deleteEmployer(Integer id) {
        employerRepository.deleteById(id);
    }
}
