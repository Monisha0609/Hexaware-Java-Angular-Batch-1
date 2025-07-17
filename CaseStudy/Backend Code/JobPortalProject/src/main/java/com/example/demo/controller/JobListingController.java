package com.example.demo.controller;

import com.example.demo.model.Employer;
import com.example.demo.model.JobListing;
import com.example.demo.service.JobListingService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/joblisting")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class JobListingController {

    private final JobListingService jobListingService;

    @PostMapping("/post")
    @PreAuthorize("hasRole('EMPLOYER')")
    public JobListing postJob(@RequestBody JobListing job) {
        return jobListingService.postJob(job);
    }

    @GetMapping("/employer/{id}")
    @PreAuthorize("hasRole('EMPLOYER')")
    public List<JobListing> getByEmployer(@PathVariable Employer id) {
        return jobListingService.getJobsByEmployer(id);
    }


    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('JOBSEEKER')")
    public List<JobListing> getAllJobs() {
        return jobListingService.getAllJobs();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('EMPLOYER')")
    public JobListing update(@PathVariable Integer id, @RequestBody JobListing jobListing) {
        return jobListingService.updateJob(id, jobListing);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('EMPLOYER')")
    public void delete(@PathVariable Integer id) {
        jobListingService.deleteJob(id);
    }
}
