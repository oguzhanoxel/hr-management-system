package com.oguzhan.hrmanagementsystem.business.abstracts;

import java.util.List;

import com.oguzhan.hrmanagementsystem.core.utilities.results.DataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.entities.concretes.Employer;

public interface EmployerService {
    DataResult<List<Employer>> getAll();
    DataResult<Employer> get(int id);
    Result add(Employer employer);
    Result delete(Employer employer);
    Result update(Employer employer);
}
