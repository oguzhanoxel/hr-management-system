package com.oguzhan.hrmanagementsystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhan.hrmanagementsystem.business.abstracts.EmployerService;
import com.oguzhan.hrmanagementsystem.business.constants.Messages;
import com.oguzhan.hrmanagementsystem.core.utilities.BusinessRules;
import com.oguzhan.hrmanagementsystem.core.utilities.results.DataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.ErrorResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.core.utilities.results.SuccessDataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.SuccessResult;
import com.oguzhan.hrmanagementsystem.core.verification.EmailVerificationManager;
import com.oguzhan.hrmanagementsystem.core.verification.VerificationService;
import com.oguzhan.hrmanagementsystem.dataAccess.abstracts.EmployerDao;
import com.oguzhan.hrmanagementsystem.entities.concretes.Employer;
import com.oguzhan.hrmanagementsystem.entities.concretes.JobSeeker;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private VerificationService emailVerification = new EmailVerificationManager();
	
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
		var result = BusinessRules.run(
				this.checkFields(employer),
				this.checkPassword(employer),
				this.checkUserExists(employer),
				this.emailVerification.verify(employer));
		
		if(!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		
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
	
	private Result checkFields(Employer employer) {
		
		if(employer.getEmail().isBlank() ||
				employer.getPassword().isBlank() ||
				employer.getConfirmPassword().isBlank() ||
				employer.getCompanyName().isBlank() ||
				employer.getPhoneNumber().isBlank() ||
				employer.getWebsite().isBlank()
				) {
			return new ErrorResult("Empty Field.");
		}
		return new SuccessResult();
	}
	
	private Result checkUserExists(Employer employer) {
		var employers  = this.employerDao.findByEmail(employer.getEmail());
		for(Employer eachEmployer : employers)
		{
			if(eachEmployer.getEmail().equals(employer.getEmail())){
				return new ErrorResult("User Exists.");
			}			
		}
		
		return new SuccessResult();
	}
	
	private Result checkPassword(Employer employer) {
		if(employer.getPassword().equals(employer.getConfirmPassword())) {
			return new SuccessResult();
		}
		return new ErrorResult("Confirm password did not matched.");
	}
}
