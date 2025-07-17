package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Application {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applicationId;

    @ManyToOne
    @JoinColumn(name = "jobId", nullable = false)
    private JobListing job;

    @ManyToOne
    @JoinColumn(name = "jobseekerId", nullable = false)
    private JobSeeker jobseeker;

    @Column
    private String resumeLink;

    @Temporal(TemporalType.DATE)
    private Date applicationDate;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
    
}