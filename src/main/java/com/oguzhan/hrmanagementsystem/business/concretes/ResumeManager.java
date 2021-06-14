package com.oguzhan.hrmanagementsystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhan.hrmanagementsystem.business.abstracts.ResumeService;
import com.oguzhan.hrmanagementsystem.business.constants.Messages;
import com.oguzhan.hrmanagementsystem.core.utilities.results.DataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.core.utilities.results.SuccessDataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.SuccessResult;
import com.oguzhan.hrmanagementsystem.dataAccess.abstracts.ResumeDao;
import com.oguzhan.hrmanagementsystem.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao) {
		super();
		this.resumeDao = resumeDao;
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(resumeDao.findAll());
	}

	@Override
	public DataResult<List<Resume>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<Resume>>(resumeDao.findByJobSeeker_Id(jobSeekerId));
	}

	@Override
	public DataResult<Resume> get(int id) {
		return new SuccessDataResult<Resume>(resumeDao.findById(id).get());
	}

	@Override
	public Result add(Resume resume) {
		resumeDao.save(resume);
		return new SuccessResult(Messages.added);
	}

	@Override
	public Result delete(Resume resume) {
		resumeDao.delete(resume);
		return new SuccessResult(Messages.deleted);
	}

	@Override
	public Result update(Resume resume) {
		resumeDao.save(resume);
		return new SuccessResult(Messages.updated);
	}

}
