package com.oguzhan.hrmanagementsystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhan.hrmanagementsystem.business.abstracts.EmployerService;
import com.oguzhan.hrmanagementsystem.core.utilities.results.DataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers/")
public class EmployersController {

	private EmployerService employerService;
	
	@Autowired
    public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}


	@GetMapping("getall")
    public DataResult<List<Employer>> getAll(){
        return employerService.getAll();
    }


    @GetMapping("get")
    public DataResult<Employer> get(int id){
        return employerService.get(id);
    }


    @PostMapping("add")
    public Result add(@RequestBody Employer employer){
        return employerService.add(employer);
    }


    @PostMapping("delete")
    public Result delete(@RequestBody Employer employer){
    	return employerService.delete(employer);
    }


    @PostMapping("update")
    public Result update(@RequestBody Employer employer){
    	return employerService.update(employer);
    }
}
