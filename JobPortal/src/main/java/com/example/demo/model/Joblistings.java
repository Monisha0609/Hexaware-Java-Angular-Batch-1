package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Joblistings")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Joblistings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Job_id")
    private int jobId;

    @Column(name = "Employer_id")
    private int employerId;

    @Column(name = "Job_title")
    private String jobTitle;

    @Column(name = "Description")
    private String description;

    @Column(name = "Qualifications")
    private String qualifications;

    @Column(name = "Location")
    private String location;

    @Column(name = "Date_posted")
    private Date datePosted;

    @Column(name = "Salary_range")
    private String salaryRange;
}