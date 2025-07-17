package com.example.demo.controller;

import com.example.demo.model.JobSeeker;
import com.example.demo.model.Resume;
import com.example.demo.service.ResumeService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping("/upload")
    @PreAuthorize("hasRole('JOBSEEKER')")
    public Resume upload(@RequestBody Resume resume) {
        return resumeService.uploadResume(resume);
    }

    @GetMapping("/jobseeker")
    @PreAuthorize("hasRole('JOBSEEKER')")
    public List<Resume> getByJobseeker(@RequestParam JobSeeker jobseeker) {
        return resumeService.getResumesByJobseeker(jobseeker);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('JOBSEEKER')")
    public Resume update(@PathVariable Integer id, @RequestBody Resume updated) {
        return resumeService.updateResume(id, updated);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('JOBSEEKER')")
    public void delete(@PathVariable Integer id) {
        resumeService.deleteResume(id);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('EMPLOYER')")
    public List<Resume> getAll() {
        return resumeService.getAllResumes();
    }
}
