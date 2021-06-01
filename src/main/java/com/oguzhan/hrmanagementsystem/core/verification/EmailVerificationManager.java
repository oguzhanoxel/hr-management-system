package com.oguzhan.hrmanagementsystem.core.verification;

import org.springframework.stereotype.Service;

import com.oguzhan.hrmanagementsystem.core.entities.User;
import com.oguzhan.hrmanagementsystem.core.utilities.results.ErrorResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.core.utilities.results.SuccessResult;

@Service
public class EmailVerificationManager implements VerificationService {

	@Override
	public Result verify(User user) {
		if(true) {
			return new SuccessResult("verified.");
		}
		return new ErrorResult("verification failed."); 
	}

}
