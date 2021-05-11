package com.oguzhan.hrmanagementsystem.business.abstracts;

import java.util.List;

import com.oguzhan.hrmanagementsystem.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
}
