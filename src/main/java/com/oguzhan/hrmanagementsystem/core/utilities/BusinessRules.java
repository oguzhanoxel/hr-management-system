package com.oguzhan.hrmanagementsystem.core.utilities;

import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.core.utilities.results.SuccessResult;

public class BusinessRules {
	
	 public static Result run(Result... logics){
	        for (Result logic : logics) {
	            if (!logic.isSuccess()){
	                return logic;
	            }
	        }
	        return new SuccessResult();
    }

}
