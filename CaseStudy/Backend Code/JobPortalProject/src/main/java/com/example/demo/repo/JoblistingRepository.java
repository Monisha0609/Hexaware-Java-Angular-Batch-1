package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employer;
import com.example.demo.model.JobListing;

@Repository
public interface JoblistingRepository extends JpaRepository<JobListing, Integer> {
	List<JobListing> findByEmployer(Employer id);
}