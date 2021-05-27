package com.oguzhan.hrmanagementsystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhan.hrmanagementsystem.business.abstracts.EmployerService;
import com.oguzhan.hrmanagementsystem.business.constants.Messages;
import com.oguzhan.hrmanagementsystem.core.utilities.results.DataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.core.utilities.results.SuccessDataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.SuccessResult;
import com.oguzhan.hrmanagementsystem.dataAccess.abstracts.EmployerDao;
import com.oguzhan.hrmanagementsystem.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	
	@Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll());
	}

	@Override
	public DataResult<Employer> get(int id) {
		return new SuccessDataResult<Employer>(employerDao.findById(id).get());
	}

	@Override
	public Result add(Employer employer) {
		employerDao.save(employer);
		return new SuccessResult(Messages.added);
	}

	@Override
	public Result delete(Employer employer) {
		employerDao.delete(employer);
        return new SuccessResult(Messages.deleted);
	}

	@Override
	public Result update(Employer employer) {
	   employerDao.save(employer);
       return new SuccessResult(Messages.updated);
	}

}
