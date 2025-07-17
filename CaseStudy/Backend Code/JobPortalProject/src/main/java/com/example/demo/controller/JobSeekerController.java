package com.example.demo.controller;

import com.example.demo.model.JobSeeker;
import com.example.demo.service.JobseekerService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobseeker")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class JobSeekerController {

    private final JobseekerService jobSeekerService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('JOBSEEKER')")
    public JobSeeker create(@RequestBody JobSeeker jobSeeker) {
        return jobSeekerService.createJobSeeker(jobSeeker);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('EMPLOYER')")
    public List<JobSeeker> getAll() {
        return jobSeekerService.getAllJobSeekers();
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('JOBSEEKER')")
    public List<JobSeeker> getByUserId(@PathVariable Integer userId) {
        return jobSeekerService.getJobSeekersByUserId(userId);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('JOBSEEKER')")
    public JobSeeker update(@PathVariable Integer id, @RequestBody JobSeeker updatedJobSeeker) {
        return jobSeekerService.updateJobSeeker(id, updatedJobSeeker);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('JOBSEEKER')")
    public void delete(@PathVariable Integer id) {
        jobSeekerService.deleteJobSeeker(id);
    }
}
