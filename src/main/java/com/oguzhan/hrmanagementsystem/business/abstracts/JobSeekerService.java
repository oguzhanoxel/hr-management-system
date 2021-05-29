package com.oguzhan.hrmanagementsystem.business.abstracts;

import java.util.List;

import com.oguzhan.hrmanagementsystem.core.utilities.results.DataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.entities.concretes.JobSeeker;

public interface JobSeekerService {

	  DataResult<List<JobSeeker>> getAll();
	    DataResult<JobSeeker> get(int id);
	    Result add(JobSeeker jobSeeker);
	    Result delete(JobSeeker jobSeeker);
	    Result update(JobSeeker jobSeeker);
	
}
