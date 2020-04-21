package com.am.service;

import com.am.pojo.TRoute;
import com.am.util.AMResult;
import com.am.util.EasyUIResult;

public interface RouteService {

	public EasyUIResult getRoute(TRoute tRoute);

	public AMResult addRoute(TRoute tRoute);

	public AMResult updateRoute(TRoute tRoute);

	public AMResult deleteRoute(Integer routeid);

}
