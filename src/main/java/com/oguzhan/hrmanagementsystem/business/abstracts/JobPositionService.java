package com.oguzhan.hrmanagementsystem.business.abstracts;

import java.util.List;

import com.oguzhan.hrmanagementsystem.core.utilities.results.DataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();
    DataResult<JobPosition> get(int id);
    Result add(JobPosition jobPosition);
    Result delete(JobPosition jobPosition);
    Result update(JobPosition jobPosition);
}
