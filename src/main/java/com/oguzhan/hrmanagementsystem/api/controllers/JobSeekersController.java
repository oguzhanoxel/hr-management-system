package com.oguzhan.hrmanagementsystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhan.hrmanagementsystem.business.abstracts.JobSeekerService;
import com.oguzhan.hrmanagementsystem.core.utilities.results.DataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.ErrorResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.core.utilities.results.SuccessResult;
import com.oguzhan.hrmanagementsystem.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers/")
public class JobSeekersController {
	
	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("getall")
	public DataResult<List<JobSeeker>> getAll(){
		return this.jobSeekerService.getAll();
	}
	
	@GetMapping("get")
	public DataResult<JobSeeker> get(int id) {
		return this.jobSeekerService.get(id);
	}
	
	@PostMapping("register")
	public Result add(@RequestBody JobSeeker jobSeeker){
		var result = this.jobSeekerService.add(jobSeeker);
		if(!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		return new SuccessResult("Registration Successful. Check your email...");
	}
	
	@PostMapping("update")
	public Result update(@RequestBody JobSeeker jobSeeker) {
		this.jobSeekerService.update(jobSeeker);
		return new SuccessResult("Updated.");
	}
	
	@PostMapping("delete")
	public Result delete(@RequestBody JobSeeker jobSeeker) {
		this.jobSeekerService.delete(jobSeeker);
		return new SuccessResult("Deleted.");
	}
}
