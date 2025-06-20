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
@Table(name = "Applications")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Applications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Application_id")
    private int applicationId;

    @Column(name = "Job_id")
    private int jobId;

    @Column(name = "Jobseeker_id")
    private int jobseekerId;

    @Column(name = "Resume_link")
    private String resumeLink;

    @Column(name = "Application_date")
    private Date applicationDate;

    @Column(name = "Status")
    private String status;
}