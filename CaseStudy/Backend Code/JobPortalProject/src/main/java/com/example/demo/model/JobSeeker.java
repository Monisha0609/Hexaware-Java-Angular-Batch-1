package com.example.demo.model;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
public class JobSeeker {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobseekerId;

    @Column
    private String fullName;

    @Column
    private String phoneNumber;

    @Column
    private String education;

    @Column(columnDefinition = "TEXT")
    private String experience;

    @Column
    private String resume;

    @Column
    private String skill;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    
}
