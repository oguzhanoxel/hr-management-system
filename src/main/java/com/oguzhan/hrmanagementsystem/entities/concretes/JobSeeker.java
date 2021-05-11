package com.oguzhan.hrmanagementsystem.entities.concretes;

import java.util.Date;

import com.oguzhan.hrmanagementsystem.entities.abstracts.BaseUser;

public class JobSeeker extends BaseUser {

	private String tcNo;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	
	public JobSeeker() {}
	
	public JobSeeker(int userId, String email, String password, boolean verified,
			String tcNo, String firstName, String lastName, Date dateOfBirth) {
		
		super(userId, email, password, verified);
		this.tcNo = tcNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	public String getTcNo() {
		return tcNo;
	}

	public void setTcNo(String tcNo) {
		this.tcNo = tcNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
