package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.JobSeeker;
import com.example.demo.model.Resume;
import com.example.demo.repo.ResumeRepository;

import java.util.Date;
import java.util.List;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    public Resume uploadResume(Resume resume) {
        resume.setLastUpdated(new Date());
        return resumeRepository.save(resume);
    }

    public List<Resume> getResumesByJobseeker(JobSeeker jobseeker) {
        return resumeRepository.findByJobseeker(jobseeker);
    }

    public Resume updateResume(Integer id, Resume updated) {
        Resume existing = resumeRepository.findById(id).orElseThrow();
        existing.setResumeTitle(updated.getResumeTitle());
        existing.setDocumentLink(updated.getDocumentLink());
        existing.setLastUpdated(new Date());
        return resumeRepository.save(existing);
    }

    public void deleteResume(Integer id) {
        resumeRepository.deleteById(id);
    }

    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }
}
