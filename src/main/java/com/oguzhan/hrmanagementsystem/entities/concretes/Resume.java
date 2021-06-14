package com.oguzhan.hrmanagementsystem.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="resumes")
public class Resume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	@NotNull
	@NotBlank
	private String firstName;
	
	@Column(name="last_name")
	@NotNull
	@NotBlank
	private String lastName;
	
	@Column(name="cover_letter")
	@NotNull
	@NotBlank
	private String coverLetter;
	
	@JsonIgnore
	@OneToMany(mappedBy="resume")
	private List<Contact> contacts; 
	
	@JsonIgnore
	@OneToMany(mappedBy="resume")
	private List<Education> educations;
	
	@JsonIgnore
	@OneToMany(mappedBy="resume")
	private List<WorkExperience> workExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy="resume")
	private List<Language> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy="resume")
	private List<Skill> skills;
	
	@JsonIgnore
	@OneToMany(mappedBy="resume")
	private List<Certification> certifications;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;

}
