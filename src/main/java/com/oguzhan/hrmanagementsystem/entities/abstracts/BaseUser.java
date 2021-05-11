package com.oguzhan.hrmanagementsystem.entities.abstracts;

public abstract class BaseUser {
	
	private int userId;
	private String email;
	private String password;
	private boolean verified;
	
	public BaseUser() {}
	
	public BaseUser(int userId, String email, String password, boolean verified) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.verified = verified;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public int getUser_id() {
		return userId;
	}

}
