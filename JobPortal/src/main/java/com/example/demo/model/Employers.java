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
@Table(name = "Employers")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employers {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employer_id")
    private int employerId;

    @Column(name = "User_id")
    private int userId;

    @Column(name = "Company_name")
    private String companyName;

    @Column(name = "Contact_number")
    private String contactNumber;

    @Column(name = "Location")
    private String location;

}
