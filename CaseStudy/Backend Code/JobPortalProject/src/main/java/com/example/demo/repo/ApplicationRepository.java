package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Application;
import com.example.demo.model.JobListing;
import com.example.demo.model.JobSeeker;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
	
	 List<Application> findByJobseeker(JobSeeker jobseeker);

	    List<Application> findByJob(JobListing job);
}
