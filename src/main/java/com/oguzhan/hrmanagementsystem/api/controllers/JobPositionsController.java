package com.oguzhan.hrmanagementsystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhan.hrmanagementsystem.business.abstracts.JobPositionService;
import com.oguzhan.hrmanagementsystem.core.utilities.results.DataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/job-positions/")
public class JobPositionsController {
	
	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("getall")
	public DataResult<List<JobPosition>> getAll(){
		return this.jobPositionService.getAll();
	}
	
	@GetMapping("get")
	public DataResult<JobPosition> get(int id){
		return this.jobPositionService.get(id);
	}
	
	@PostMapping("add")
	public Result add(JobPosition jobPosition) {
		return this.jobPositionService.add(jobPosition);
	}
	
	@PostMapping("update")
	public Result update(JobPosition jobPosition) {
		return this.jobPositionService.update(jobPosition);
	}
	
	@PostMapping("delete")
	public Result delete(JobPosition jobPositon) {
		return this.jobPositionService.delete(jobPositon);
	}

}
