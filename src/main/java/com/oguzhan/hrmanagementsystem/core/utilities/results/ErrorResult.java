package com.oguzhan.hrmanagementsystem.core.utilities.results;

public class ErrorResult extends Result {
	
	public ErrorResult() {
		super(false);
	}
	
	public ErrorResult(String message) {
		super(false, message);
	}

}