package com.am.service;

import com.am.pojo.TVehicle;
import com.am.util.AMResult;
import com.am.util.EasyUIResult;

public interface VehicleService {

	public EasyUIResult getVehicles(TVehicle tVehicle);

	public AMResult addVehicle(TVehicle tVehicle);

	public AMResult updateVehicle(TVehicle tVehicle);

	public AMResult deleteVehicle(Integer vehicleid);

	public AMResult updateVehicleStatus(TVehicle tVehicle);

}
