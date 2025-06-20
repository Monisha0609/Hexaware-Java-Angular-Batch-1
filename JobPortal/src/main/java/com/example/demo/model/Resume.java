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
@Table(name = "Resume")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Resume_id")
    private int resumeId;

    @Column(name = "Jobseeker_id")
    private int jobseekerId;

    @Column(name = "Resume_title")
    private String resumeTitle;

    @Column(name = "Document_link")
    private String documentLink;

    @Column(name = "Last_updated")
    private Date lastUpdated;
}
