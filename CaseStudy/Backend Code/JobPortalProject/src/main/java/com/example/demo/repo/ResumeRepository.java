package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.JobSeeker;
import com.example.demo.model.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Integer> {
    List<Resume> findByJobseeker(JobSeeker jobseeker);
}