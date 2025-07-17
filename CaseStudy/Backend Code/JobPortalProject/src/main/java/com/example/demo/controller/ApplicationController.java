package com.example.demo.controller;

import com.example.demo.model.Application;
import com.example.demo.model.JobListing;
import com.example.demo.model.JobSeeker;
import com.example.demo.service.ApplicationService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/application")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping("/apply")
    @PreAuthorize("hasRole('JOBSEEKER')")
    public Application apply(@RequestBody Application application) {
        return applicationService.apply(application);
    }

    @GetMapping("/jobseeker")
    @PreAuthorize("hasRole('JOBSEEKER')")
    public List<Application> getByJobseeker(@RequestBody JobSeeker jobseeker) {
        return applicationService.getByJobseeker(jobseeker);
    }

    @GetMapping("/job")
    @PreAuthorize("hasRole('EMPLOYER')")
    public List<Application> getByJob(@RequestBody JobListing job) {
        return applicationService.getByJob(job);
    }

    @PutMapping("/status/{id}")
    @PreAuthorize("hasRole('EMPLOYER')")
    public Application updateStatus(@PathVariable Integer id, @RequestParam String status) {
        return applicationService.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('EMPLOYER', 'JOBSEEKER')")
    public void delete(@PathVariable Integer id) {
        applicationService.deleteApplication(id);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('EMPLOYER')")
    public List<Application> getAll() {
        return applicationService.getAllApplications();
    }
}
