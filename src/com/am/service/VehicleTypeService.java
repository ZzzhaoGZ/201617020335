package com.am.service;

import com.am.pojo.TVehicletype;
import com.am.util.AMResult;
import com.am.util.EasyUIResult;

public interface VehicleTypeService {
	
	public EasyUIResult getTVehicletypees(TVehicletype tTVehicletypee);

	public AMResult addTVehicletypee(TVehicletype tTVehicletypee);

	public AMResult updateTVehicletypee(TVehicletype tTVehicletypee);

	public AMResult deleteTVehicletypee(Integer TVehicletypeeid);

}
