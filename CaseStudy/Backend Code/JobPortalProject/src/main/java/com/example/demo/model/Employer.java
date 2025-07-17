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
@Table(name = "Employers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employerId;

    @Column
    private String companyName;

    @Column
    private String contactNumber;

    @Column
    private String location;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
