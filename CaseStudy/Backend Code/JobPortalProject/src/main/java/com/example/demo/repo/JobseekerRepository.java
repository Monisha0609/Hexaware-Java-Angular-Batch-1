package com.example.demo.repo;


import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.JobSeeker;

@Repository
public interface JobseekerRepository extends JpaRepository<JobSeeker, Integer> {
	List<JobSeeker> findByUserUserId(Integer userId);
}