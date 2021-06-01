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
	private MernisVerificationManager mernisVerificationManager = new MernisVerificationManager();
	private EmailVerificationManager emailVerificationManager = new EmailVerificationManager();
	
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
				this.checkPassword(jobSeeker),
				this.checkUserExists(jobSeeker),
				this.mernisVerificationManager.verify(jobSeeker),
				this.emailVerificationManager.verify(jobSeeker)
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
		var jobSeekers  = this.jobSeekerDao.findByEmailOrTcNo(jobSeeker.getEmail(), jobSeeker.getTcNo());
		for(JobSeeker eachJobSeeker : jobSeekers)
		{
			if(eachJobSeeker.getEmail().equals(jobSeeker.getEmail()) || eachJobSeeker.getTcNo().equals(jobSeeker.getTcNo())){
				return new ErrorResult("User Exists.");
			}			
		}
		
		return new SuccessResult();
	}
	
	private Result checkFields(JobSeeker jobSeeker) {
		
		if(jobSeeker.getEmail().isBlank() ||
			jobSeeker.getFirstName().isBlank() ||
			jobSeeker.getLastName().isBlank() ||
			jobSeeker.getPassword().isBlank() ||
			jobSeeker.getConfirmPassword().isBlank() ||
			jobSeeker.getDateOfBirth() == null || //TODO isBlank fonksiyonu çıkmadı ?
			jobSeeker.getTcNo().isBlank()) {
			
			return new ErrorResult("Empty Field.");
		}
		return new SuccessResult();
	}
	
	private Result checkPassword(JobSeeker jobSeeker) {
		if(jobSeeker.getPassword().equals(jobSeeker.getConfirmPassword())) {
			return new SuccessResult();
		}
		return new ErrorResult("Confirm password did not matched.");
	}

}
