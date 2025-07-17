
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
@Table(name = "Resume")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resume {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer resumeId;

	    @Column
	    private String resumeTitle;

	    @Column
	    private String documentLink;

	    @Temporal(TemporalType.DATE)
	    private Date lastUpdated;

	    @ManyToOne
	    @JoinColumn(name = "jobseekerId", nullable = false)
	    private JobSeeker jobseeker;

}
