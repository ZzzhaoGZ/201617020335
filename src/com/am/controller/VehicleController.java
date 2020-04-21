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

import com.am.pojo.TVehicle;
import com.am.pojo.TVehicletype;
import com.am.pojo.VehicleVO;
import com.am.service.VehicleService;
import com.am.util.AMResult;
import com.am.util.CheckBoxVO;
import com.am.util.EasyUIResult;

@Controller
public class VehicleController {

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
	private VehicleService vehicleService;

	@RequestMapping("/vehicle/getvehicle")
	@ResponseBody
	public EasyUIResult getVehicle(TVehicle tVehicle) {
		return vehicleService.getVehicles(tVehicle);
	}

	@RequestMapping("/vehicle/addvehicle")
	@ResponseBody
	public AMResult addVehicle(TVehicle tVehicle) {
		return vehicleService.addVehicle(tVehicle);
	}

	@RequestMapping("/vehicle/updatevehicle")
	@ResponseBody
	public AMResult updateVehicle(TVehicle tVehicle) {
		return vehicleService.updateVehicle(tVehicle);
	}

	@RequestMapping("/vehicle/deletevehicle")
	@ResponseBody
	public AMResult deleteVehicle(Integer vehicleid) {
		return vehicleService.deleteVehicle(vehicleid);
	}

	@RequestMapping("/vehicle/getvehiclecheckboxdata")
	@ResponseBody
	public List<CheckBoxVO> getVehicleCheckBoxData() {

		List<CheckBoxVO> checkResult = new ArrayList<CheckBoxVO>();
		TVehicle tVehicle = new TVehicle();
		tVehicle.setVehiclestatus("1");
		EasyUIResult result = vehicleService.getVehicles(tVehicle);
		List<VehicleVO> list = (List<VehicleVO>) result.getRows();
		if (list != null && list.size() > 0) {
			for (VehicleVO vehicleVO : list) {
				CheckBoxVO vo = new CheckBoxVO();
				vo.setId(String.valueOf(vehicleVO.getVehicleid()));
				vo.setText(vehicleVO.getVehiclenum()+"(载重"+vehicleVO.getVehicleload()+")");
				checkResult.add(vo);
			}
		}
		return checkResult;
	}

}
