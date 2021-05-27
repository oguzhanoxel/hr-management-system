package com.oguzhan.hrmanagementsystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhan.hrmanagementsystem.business.abstracts.JobSeekerService;
import com.oguzhan.hrmanagementsystem.business.constants.Messages;
import com.oguzhan.hrmanagementsystem.core.utilities.BusinessRules;
import com.oguzhan.hrmanagementsystem.core.utilities.results.DataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.ErrorResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.core.utilities.results.SuccessDataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.SuccessResult;
import com.oguzhan.hrmanagementsystem.core.verification.EmailVerificationManager;
import com.oguzhan.hrmanagementsystem.core.verification.MernisVerificationManager;
import com.oguzhan.hrmanagementsystem.core.verification.VerificationService;
import com.oguzhan.hrmanagementsystem.dataAccess.abstracts.JobSeekerDao;
import com.oguzhan.hrmanagementsystem.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {
	
	private JobSeekerDao jobSeekerDao;
	private VerificationService mernisVerification = new MernisVerificationManager();
	private VerificationService emailVerification = new EmailVerificationManager();
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
	}

	@Override
	public DataResult<JobSeeker> get(int id) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findById(id).get());
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		var result = BusinessRules.run(
				this.checkFields(jobSeeker),
				this.checkUserExists(jobSeeker),
				this.mernisVerification.verify(jobSeeker),
				this.emailVerification.send(jobSeeker)
				);
		if(!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult(Messages.added);
	}

	@Override
	public Result delete(JobSeeker jobSeeker) {
		this.jobSeekerDao.delete(jobSeeker);
		return new SuccessResult(Messages.deleted);
	}

	@Override
	public Result update(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult(Messages.updated);
	}
	
	private Result checkUserExists(JobSeeker jobSeeker) {
		
		for(JobSeeker eachJobSeeker:this.jobSeekerDao.findAll()) {
			if(jobSeeker == eachJobSeeker) {
				return new ErrorResult("user exists.");
			}
		}
		return new SuccessResult();
	}
	
	private Result checkFields(JobSeeker jobSeeker) {
		
		if(jobSeeker.getEmail().isBlank() ||
			jobSeeker.getFirstName().isBlank() ||
			jobSeeker.getLastName().isBlank() ||
			jobSeeker.getPassword().isBlank() ||
			jobSeeker.getTcNo().isBlank()) {
			
			return new ErrorResult("Empty Field.");
		}
			
		
		return new SuccessResult();
	}

	@Override
	public Result verify(JobSeeker jobSeeker) {
		if(this.emailVerification.verify(jobSeeker).isSuccess()) {
			return new SuccessResult(Messages.verified);
		}
		return new ErrorResult(Messages.verifyFailed);
	}

}
