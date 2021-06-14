package com.oguzhan.hrmanagementsystem.business.abstracts;

import java.util.List;

import com.oguzhan.hrmanagementsystem.core.utilities.results.DataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.entities.concretes.Resume;

public interface ResumeService {
	
	DataResult<List<Resume>> getAll();
	DataResult<List<Resume>> getAllByJobSeekerId(int jobSeekerId);
    DataResult<Resume> get(int id);
    Result add(Resume resume);
    Result delete(Resume resume);
    Result update(Resume resume);
    
}
