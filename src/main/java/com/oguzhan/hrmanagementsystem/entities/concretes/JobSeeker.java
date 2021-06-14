package com.oguzhan.hrmanagementsystem.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oguzhan.hrmanagementsystem.core.entities.User;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@PrimaryKeyJoinColumn(name="id")
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_seekers")
public class JobSeeker extends User {
	
	@Column(name="tc_no")
	@NotBlank
	@NotNull
	private String tcNo;
	
	@Column(name="first_name")
	@NotBlank
	@NotNull
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank
	@NotNull
	private String lastName;
	
	@Column(name="date_of_birth")
	@NotBlank
	@NotNull
	private LocalDate dateOfBirth;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobSeeker")
	private List<Resume> resumes; 

}
