package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Jobseekers;
import com.example.demo.service.JobSeekerService;

@RestController
public class JobSeekerController {

    @Autowired
    private JobSeekerService jobSeekerService;

    @GetMapping("/showJobSeekers")
    public List<Jobseekers> showJobSeekers() {
        return jobSeekerService.showJobSeekers();
    }

    @GetMapping("/jobSeekerLogin/{username}/{password}")
    public String loginJobSeeker(@PathVariable String username, @PathVariable String password) {
        int result = jobSeekerService.authenticate(username, password);
        return String.valueOf(result);
    }

    @GetMapping("/searchJobSeekerById/{jobseekerId}")
    public ResponseEntity<Jobseekers> searchJobSeekerById(@PathVariable int jobseekerId) {
        return jobSeekerService.searchByJobseekerId(jobseekerId);
    }

    @GetMapping("/searchJobSeekerByName/{fullName}")
    public ResponseEntity<Jobseekers> searchJobSeekerByName(@PathVariable String fullName) {
        return jobSeekerService.searchByFullName(fullName);
    }
}
