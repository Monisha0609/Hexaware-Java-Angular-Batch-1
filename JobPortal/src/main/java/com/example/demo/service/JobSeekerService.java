package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Jobseekers;
import com.example.demo.model.Users;
import com.example.demo.repo.JobseekerRepository;
import com.example.demo.repo.UserRepository;

@Service
public class JobSeekerService {

    @Autowired
    private JobseekerRepository jobseekerRepo;

    @Autowired
    private UserRepository userRepo;

    public List<Jobseekers> showJobSeekers() {
        return jobseekerRepo.findAll();
    }

    public int authenticate(String username, String password) {
        Users user = userRepo.findByUsernameAndPassword(username, password);
        if (user != null && "Jobseeker".equalsIgnoreCase(user.getRole())) {
            return 1;
        }
        return 0;
    }

    public ResponseEntity<Jobseekers> searchByJobseekerId(int jobseekerId) {
        Jobseekers seeker = jobseekerRepo.findById(jobseekerId)
                .orElseThrow(() -> new ResourceNotFoundException("Jobseeker with ID " + jobseekerId + " not found"));
        return new ResponseEntity<>(seeker, HttpStatus.OK);
    }

    public ResponseEntity<Jobseekers> searchByFullName(String fullName) {
        Jobseekers seeker = jobseekerRepo.findByFullName(fullName);
        if (seeker != null) {
            return new ResponseEntity<>(seeker, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Jobseeker with name " + fullName + " not found");
        }
    }
}
