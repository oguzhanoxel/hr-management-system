package com.oguzhan.hrmanagementsystem.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="locations")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job_notices"})
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="country")
	@NotNull
	@NotBlank
	private String country;

	@Column(name="city")
	@NotNull
	@NotBlank
	private String city;
	
	@Column(name="address")
	private String address;
	
	@OneToOne(mappedBy="location")
	private JobNotice jobNotice;

}
