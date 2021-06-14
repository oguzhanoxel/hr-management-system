package com.oguzhan.hrmanagementsystem.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="educations")
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="department")
	private String department;
	
	@Column(name="description")
	private String description;
	
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="date_of_graduation")
	private LocalDate dateOfGraduation;
	
	@Column(name="country")
	private String country;
	
	@Column(name="city")
	private String city;
	
	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;

}
