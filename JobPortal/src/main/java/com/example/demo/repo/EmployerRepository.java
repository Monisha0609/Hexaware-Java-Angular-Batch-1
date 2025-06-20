package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employers;

@Repository
public interface EmployerRepository extends JpaRepository<Employers, Integer> {
    
    Employers findByUserId(int userId); // link with Users
    
    Employers findByCompanyName(String companyName);
}
