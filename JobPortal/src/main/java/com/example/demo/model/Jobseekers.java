package com.example.demo.model;

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
@Table(name = "Jobseekers")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Jobseekers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Jobseeker_id")
    private int jobseekerId;

    @Column(name = "User_id")
    private int userId;

    @Column(name = "Full_name")
    private String fullName;

    @Column(name = "Phone_number")
    private String phoneNumber;

    @Column(name = "Education")
    private String education;

    @Column(name = "Experience")
    private String experience;

    @Column(name = "Resume")
    private String resume;

    @Column(name = "Skill")
    private String skill;
}