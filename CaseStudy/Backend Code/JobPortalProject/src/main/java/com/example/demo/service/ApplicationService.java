package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Application;
import com.example.demo.model.ApplicationStatus;
import com.example.demo.model.JobListing;
import com.example.demo.model.JobSeeker;
import com.example.demo.repo.ApplicationRepository;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public Application apply(Application application) {
        application.setApplicationDate(new Date());
        application.setStatus(ApplicationStatus.Applied);
        return applicationRepository.save(application);
    }

    public List<Application> getByJobseeker(JobSeeker jobseeker) {
        return applicationRepository.findByJobseeker(jobseeker);
    }

    public List<Application> getByJob(JobListing job) {
        return applicationRepository.findByJob(job);
    }

    public Application updateStatus(Integer id, String status) {
        Application application = applicationRepository.findById(id).orElseThrow();
        application.setStatus(ApplicationStatus.valueOf(status));
        return applicationRepository.save(application);
    }

    public void deleteApplication(Integer id) {
        applicationRepository.deleteById(id);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
}
