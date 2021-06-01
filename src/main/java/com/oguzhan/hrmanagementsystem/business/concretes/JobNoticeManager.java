package com.oguzhan.hrmanagementsystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.oguzhan.hrmanagementsystem.business.abstracts.JobNoticeService;
import com.oguzhan.hrmanagementsystem.business.constants.Messages;
import com.oguzhan.hrmanagementsystem.core.utilities.results.DataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.core.utilities.results.SuccessDataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.SuccessResult;
import com.oguzhan.hrmanagementsystem.dataAccess.abstracts.JobNoticeDao;
import com.oguzhan.hrmanagementsystem.entities.concretes.JobNotice;

@Service
public class JobNoticeManager implements JobNoticeService {
	
	private JobNoticeDao jobNoticeDao;

	@Autowired
	public JobNoticeManager(JobNoticeDao jobNoticeDao) {
		super();
		this.jobNoticeDao = jobNoticeDao;
	}

	@Override
	public DataResult<List<JobNotice>> getAll() {
		return new SuccessDataResult<List<JobNotice>>(this.jobNoticeDao.findAll());
	}

	@Override
	public DataResult<JobNotice> get(int id) {
		return new SuccessDataResult<JobNotice>(this.jobNoticeDao.findById(id).get());
	}

	@Override
	public Result add(JobNotice jobNotice) {
		this.jobNoticeDao.save(jobNotice);
		return new SuccessResult(Messages.added);
	}

	@Override
	public Result delete(JobNotice jobNotice) {
		this.jobNoticeDao.delete(jobNotice);
		return new SuccessResult(Messages.deleted);
	}

	@Override
	public Result update(JobNotice jobNotice) {
		this.jobNoticeDao.save(jobNotice);
		return new SuccessResult(Messages.updated);
	}
	
	@Override
	public DataResult<List<JobNotice>> getAllSortedASC(){
		Sort sort = Sort.by(Sort.Direction.ASC,"createAt");
		return new SuccessDataResult<List<JobNotice>>(this.jobNoticeDao.findAll(sort));
	}

	@Override
	public DataResult<List<JobNotice>> getAllSortedDESC() {
		Sort sort = Sort.by(Sort.Direction.DESC,"createAt");
		return new SuccessDataResult<List<JobNotice>>(this.jobNoticeDao.findAll(sort));
	}

	@Override
	public DataResult<JobNotice> activate(int id) {
		JobNotice jobNotice = this.jobNoticeDao.findById(id).get();
		jobNotice.setActive(true);
		this.jobNoticeDao.save(jobNotice);
		return new SuccessDataResult<JobNotice>(jobNotice);
	}

	@Override
	public DataResult<JobNotice> deactivate(int id) {
		JobNotice jobNotice = this.jobNoticeDao.findById(id).get();
		jobNotice.setActive(false);
		this.jobNoticeDao.save(jobNotice);
		return new SuccessDataResult<JobNotice>(jobNotice);
	}
	
	

}
