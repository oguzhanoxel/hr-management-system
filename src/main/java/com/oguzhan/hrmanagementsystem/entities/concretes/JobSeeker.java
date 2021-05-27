package com.oguzhan.hrmanagementsystem.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@PrimaryKeyJoinColumn(name="user_id")
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_seekers")
public class JobSeeker extends User {
	
	@Column(name="tc_no")
	private String tcNo;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;

}
