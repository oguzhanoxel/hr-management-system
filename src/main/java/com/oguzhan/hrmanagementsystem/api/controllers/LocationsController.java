package com.oguzhan.hrmanagementsystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhan.hrmanagementsystem.business.abstracts.LocationService;
import com.oguzhan.hrmanagementsystem.core.utilities.results.DataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.entities.concretes.Location;

@RestController
@RequestMapping("/api/locations/")
public class LocationsController {

	private LocationService locationService;

	@Autowired
	public LocationsController(LocationService locationService) {
		super();
		this.locationService = locationService;
	}
	
	@GetMapping("getall")
	public DataResult<List<Location>> getAll(){
		return this.locationService.getAll();
	}
	
	@GetMapping("get")
	public DataResult<Location> get(int id){
    	return this.locationService.get(id);
    }
    
	@PostMapping("add")
	public Result add(@RequestBody Location location) {
		return this.locationService.add(location);
	}
	
	@PostMapping("delete")
	public Result delete(@RequestBody Location location) {
		return this.locationService.delete(location);
	}
	
	@PostMapping("update")
	public Result update(@RequestBody Location location) {
    	return this.locationService.update(location);
    }
	
}
