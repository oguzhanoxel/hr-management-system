package com.oguzhan.hrmanagementsystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhan.hrmanagementsystem.business.abstracts.JobNoticeService;
import com.oguzhan.hrmanagementsystem.core.utilities.results.DataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.entities.concretes.JobNotice;

@RestController
@RequestMapping("/api/jobnotices/")
public class JobNoticesController {
	
	private JobNoticeService jobNoticeService;

	@Autowired
	public JobNoticesController(JobNoticeService jobNoticeService) {
		super();
		this.jobNoticeService = jobNoticeService;
	}
	
	@GetMapping("getall")
	public DataResult<List<JobNotice>> getAll(){
		return this.jobNoticeService.getAll();
	}
	
	@GetMapping("getallASC")
	public DataResult<List<JobNotice>> getAllSortedASC(){
		return this.jobNoticeService.getAllSortedASC();
	}
	
	@GetMapping("getallDESC")
	public DataResult<List<JobNotice>> getAllSortedDESC(){
		return this.jobNoticeService.getAllSortedDESC();
	}
	
	@GetMapping("get")
	public DataResult<JobNotice> get(int id){
		return this.jobNoticeService.get(id);
	}
	
	@PostMapping("add")
	public Result add(@RequestBody JobNotice jobNotice) {
		return this.jobNoticeService.add(jobNotice);
	}
	
	@PostMapping("delete")
	public Result delete(@RequestBody JobNotice jobNotice) {
		return this.jobNoticeService.delete(jobNotice);
	}
	
	@PostMapping("update")
	public Result update(@RequestBody JobNotice jobNotice) {
		return this.jobNoticeService.update(jobNotice);
	}
	
	@PostMapping("activate")
	public DataResult<JobNotice> activate(@RequestParam int id){
		return this.jobNoticeService.activate(id);
	}
	
	@PostMapping("deactivate")
	public DataResult<JobNotice> deactivate(@RequestParam int id){
		return this.jobNoticeService.deactivate(id);
	}

}
