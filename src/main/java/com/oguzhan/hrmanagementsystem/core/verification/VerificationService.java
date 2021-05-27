package com.oguzhan.hrmanagementsystem.core.verification;

import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.entities.concretes.User;

public interface VerificationService {
	Result verify(User user);
	Result send(User user);
}
