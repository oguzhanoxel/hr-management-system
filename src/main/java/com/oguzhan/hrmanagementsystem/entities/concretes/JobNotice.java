package com.oguzhan.hrmanagementsystem.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

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
@Table(name="job_notices")
public class JobNotice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="number_of_open_positions")
	private int numberOfOpenPositions;
	
	@Column(name="country")
	private String country;

	@Column(name="city")
	private String city;
	
	@Column(name="address")
	private String address;
	
	@Column(name="deadline")
	private Date deadline;
	
	@Column(name="is_active")
	private boolean active=true;
	
	@Column(name="created_at")
	private LocalDate createAt = LocalDate.now();
	
	@ManyToOne()
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;

}
