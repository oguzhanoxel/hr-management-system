package com.oguzhan.hrmanagementsystem.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
@Table(name="employers")
public class Employer extends User {
	
	@Column(name="company_name")
	@NotBlank
	@NotNull
	private String companyName;
	
	@Column(name="website")
	@NotBlank
	@NotNull
	private String website;
	
	@Column(name="phone_number")
	@NotBlank
	@NotNull
	private String phoneNumber;
	
}
