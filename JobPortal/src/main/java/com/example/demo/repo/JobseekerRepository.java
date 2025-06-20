package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Jobseekers;

@Repository
public interface JobseekerRepository extends JpaRepository<Jobseekers, Integer> {
    
    Jobseekers findByUserId(int userId);
    
    Jobseekers findByFullName(String fullName);
}
