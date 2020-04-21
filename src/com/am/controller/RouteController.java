package com.am.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.am.pojo.TRoute;
import com.am.pojo.TVehicle;
import com.am.pojo.VehicleVO;
import com.am.service.RouteService;
import com.am.util.AMResult;
import com.am.util.CheckBoxVO;
import com.am.util.EasyUIResult;

@Controller
public class RouteController {

	/**
	 * 用于处理Date类型参数处理
	 * 
	 * @return
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));

	}

	@Autowired
	private RouteService routeService;

	@RequestMapping("/route/getroutes")
	@ResponseBody
	public EasyUIResult getRoutes(TRoute tRoute) {
		return routeService.getRoute(tRoute);
	}

	@RequestMapping("/route/addroute")
	@ResponseBody
	public AMResult addRoute(TRoute tRoute) {
		tRoute.setRoutecreate(new Date());
		return routeService.addRoute(tRoute);
	}

	@RequestMapping("/route/updateroute")
	@ResponseBody
	public AMResult updateRoute(TRoute tRoute) {
		return routeService.updateRoute(tRoute);
	}

	@RequestMapping("/route/deleteroute")
	@ResponseBody
	public AMResult deleteRoute(Integer routeid) {
		return routeService.deleteRoute(routeid);
	}

	@RequestMapping("/route/getroutecheckboxdata")
	@ResponseBody
	public List<CheckBoxVO> getroutecheckboxdata() {
		List<CheckBoxVO> checkResult = new ArrayList<CheckBoxVO>();
		EasyUIResult result = routeService.getRoute(null);
		List<TRoute> list = (List<TRoute>) result.getRows();
		if (list != null && list.size() > 0) {
			for (TRoute tRoute : list) {
				CheckBoxVO vo = new CheckBoxVO();
				vo.setId(String.valueOf(tRoute.getRouteid()));
				vo.setText(tRoute.getRoutename());
				checkResult.add(vo);
			}
		}
		return checkResult;
	}

}
