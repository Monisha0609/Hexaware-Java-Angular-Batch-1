package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.JobSeeker;

import com.example.demo.repo.JobseekerRepository;

import java.util.List;

@Service
public class JobseekerService {

    @Autowired
    private JobseekerRepository jobSeekerRepository;

    public JobSeeker createJobSeeker(JobSeeker jobSeeker) {
        return jobSeekerRepository.save(jobSeeker);
    }

    public List<JobSeeker> getAllJobSeekers() {
        return jobSeekerRepository.findAll();
    }

    public List<JobSeeker> getJobSeekersByUserId(Integer userId) {
        return jobSeekerRepository.findByUserUserId(userId);
    }

    public JobSeeker updateJobSeeker(Integer id, JobSeeker updatedJobSeeker) {
        JobSeeker existing = jobSeekerRepository.findById(id).orElseThrow();
        existing.setFullName(updatedJobSeeker.getFullName());
        existing.setPhoneNumber(updatedJobSeeker.getPhoneNumber());
        existing.setEducation(updatedJobSeeker.getEducation());
        existing.setExperience(updatedJobSeeker.getExperience());
        existing.setResume(updatedJobSeeker.getResume());
        existing.setSkill(updatedJobSeeker.getSkill());
        return jobSeekerRepository.save(existing);
    }

    public void deleteJobSeeker(Integer id) {
        jobSeekerRepository.deleteById(id);
    }
}
