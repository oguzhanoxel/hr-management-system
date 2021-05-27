package com.oguzhan.hrmanagementsystem.core.verification;

import com.oguzhan.hrmanagementsystem.core.utilities.results.ErrorResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.core.utilities.results.SuccessResult;
import com.oguzhan.hrmanagementsystem.entities.concretes.User;

public class EmailVerificationManager implements VerificationService {

	@Override
	public Result verify(User user) {
		if(true) {
			return new SuccessResult("verified.");
		}
		return new ErrorResult("verification failed."); 
	}

	@Override
	public Result send(User user) {
		return new SuccessResult("Check "+ user.getEmail() +".");
	}

}
