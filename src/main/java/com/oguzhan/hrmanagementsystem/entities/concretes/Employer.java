package com.oguzhan.hrmanagementsystem.entities.concretes;

import com.oguzhan.hrmanagementsystem.entities.abstracts.BaseUser;

public class Employer extends BaseUser {
	
	private String companyName;
	private String website;
	private String phoneNumber;
	
	public Employer() {}
	
	public Employer(int userId, String email, String password, boolean verified,
			String companyName, String website, String phoneNumber) {
		
		super(userId, email, password, verified);
		this.companyName = companyName;
		this.website = website;
		this.phoneNumber = phoneNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
