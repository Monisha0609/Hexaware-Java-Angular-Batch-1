package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.JobListing;
import com.example.demo.model.Employer;

import com.example.demo.repo.JoblistingRepository;

import java.util.Date;
import java.util.List;

@Service
public class JobListingService {

    @Autowired
    private JoblistingRepository jobListingRepository;

    public JobListing postJob(JobListing jobListing) {
        jobListing.setDatePosted(new Date()); // java.util.Date
        return jobListingRepository.save(jobListing);
    }

    public List<JobListing> getJobsByEmployer(Employer id) {
        return jobListingRepository.findByEmployer(id);
    }

    public List<JobListing> getAllJobs() {
        return jobListingRepository.findAll();
    }

    public JobListing updateJob(Integer id, JobListing updated) {
        JobListing existing = jobListingRepository.findById(id).orElseThrow();
        existing.setJobTitle(updated.getJobTitle());
        existing.setJobDescription(updated.getJobDescription());
        existing.setQualifications(updated.getQualifications());
        existing.setLocation(updated.getLocation());
        existing.setSalaryRange(updated.getSalaryRange());
        existing.setCategory(updated.getCategory());
        return jobListingRepository.save(existing);
    }

    public void deleteJob(Integer id) {
        jobListingRepository.deleteById(id);
    }
}
