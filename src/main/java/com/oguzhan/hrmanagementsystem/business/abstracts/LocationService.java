package com.oguzhan.hrmanagementsystem.business.abstracts;

import java.util.List;

import com.oguzhan.hrmanagementsystem.core.utilities.results.DataResult;
import com.oguzhan.hrmanagementsystem.core.utilities.results.Result;
import com.oguzhan.hrmanagementsystem.entities.concretes.Location;

public interface LocationService {
	
	DataResult<List<Location>> getAll();
    DataResult<Location> get(int id);
    Result add(Location location);
    Result delete(Location location);
    Result update(Location location);

}
