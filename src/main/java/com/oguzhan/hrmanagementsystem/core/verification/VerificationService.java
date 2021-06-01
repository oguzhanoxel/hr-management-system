package com.oguzhan.hrmanagementsystem.core.verification;

import com.oguzhan.hrmanagementsystem.core.entities.User;
import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;

public interface VerificationService {
	Result verify(User user);
}
