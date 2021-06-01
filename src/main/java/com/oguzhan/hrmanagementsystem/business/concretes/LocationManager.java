package com.oguzhan.hrmanagementsystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhan.hrmanagementsystem.business.abstracts.LocationService;
import com.oguzhan.hrmanagementsystem.business.constants.Messages;
import com.oguzhan.hrmanagementsystem.core.utilities.results.DataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.core.utilities.results.SuccessDataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.SuccessResult;
import com.oguzhan.hrmanagementsystem.dataAccess.abstracts.LocationDao;
import com.oguzhan.hrmanagementsystem.entities.concretes.Location;

@Service
public class LocationManager implements LocationService {
	
	private LocationDao locationDao;

	@Autowired
	public LocationManager(LocationDao locationDao) {
		super();
		this.locationDao = locationDao;
	}

	@Override
	public DataResult<List<Location>> getAll() {
		return new SuccessDataResult<List<Location>>(this.locationDao.findAll());
	}

	@Override
	public DataResult<Location> get(int id) {
		return new SuccessDataResult<Location>(this.locationDao.findById(id).get());
	}

	@Override
	public Result add(Location location) {
		this.locationDao.save(location);
		return new SuccessResult(Messages.added);
	}

	@Override
	public Result delete(Location location) {
		this.locationDao.delete(location);
		return new SuccessResult(Messages.deleted);
	}

	@Override
	public Result update(Location location) {
		this.locationDao.save(location);
		return new SuccessResult(Messages.updated);
	}
	
	

}
