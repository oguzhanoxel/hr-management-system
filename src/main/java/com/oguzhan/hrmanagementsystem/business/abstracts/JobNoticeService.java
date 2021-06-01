package com.oguzhan.hrmanagementsystem.business.abstracts;

import java.util.List;

import com.oguzhan.hrmanagementsystem.core.utilities.results.DataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.entities.concretes.JobNotice;

public interface JobNoticeService {
	
	DataResult<List<JobNotice>> getAll();
	DataResult<List<JobNotice>> getAllSortedASC();
	DataResult<List<JobNotice>> getAllSortedDESC();
    DataResult<JobNotice> get(int id);
    DataResult<JobNotice> activate(int id);
    DataResult<JobNotice> deactivate(int id);
    Result add(JobNotice jobNotice);
    Result delete(JobNotice jobNotice);
    Result update(JobNotice jobNotice);

}
