package com.example.demo.model;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "Jobseekers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobListing {


	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer jobId;

	    @Column
	    private String jobTitle;

	    @Column(columnDefinition = "TEXT")
	    private String jobDescription;

	    @Column(columnDefinition = "TEXT")
	    private String qualifications;

	    @Column
	    private String location;

	    @Temporal(TemporalType.DATE)
	    private Date datePosted;

	    @Column
	    private String salaryRange;

	    @Column
	    private String category;

	    @ManyToOne
	    @JoinColumn(name = "employerId", nullable = false)
	    private Employer employer;
	    
}