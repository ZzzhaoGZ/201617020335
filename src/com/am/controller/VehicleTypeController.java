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

import com.am.pojo.TVehicletype;
import com.am.service.VehicleTypeService;
import com.am.util.AMResult;
import com.am.util.CheckBoxVO;
import com.am.util.EasyUIResult;

@Controller
public class VehicleTypeController {

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
	private VehicleTypeService vehicleTypeService;

	@RequestMapping("/vehicletype/getvehicletype")
	@ResponseBody
	public EasyUIResult getVehicleType() {
		return vehicleTypeService.getTVehicletypees(null);
	}

	@RequestMapping("/vehicletype/addvehicletype")
	@ResponseBody
	public AMResult addVehicleType(TVehicletype tTVehicletypee) {
		tTVehicletypee.setTypecreate(new Date());
		return vehicleTypeService.addTVehicletypee(tTVehicletypee);
	}

	@RequestMapping("/vehicletype/updatevehicletype")
	@ResponseBody
	public AMResult updateVehicleType(TVehicletype tTVehicletypee) {
		return vehicleTypeService.updateTVehicletypee(tTVehicletypee);
	}

	@RequestMapping("/vehicletype/deletevehicletype")
	@ResponseBody
	public AMResult updateVehicleType(Integer typeid) {
		return vehicleTypeService.deleteTVehicletypee(typeid);
	}

	@RequestMapping("/vehicletype/getvehicletypecheckboxdata")
	@ResponseBody
	public List<CheckBoxVO> getVehicleTypeCheckBoxData() {

		List<CheckBoxVO> checkResult = new ArrayList<CheckBoxVO>();
		EasyUIResult result = vehicleTypeService.getTVehicletypees(null);
		List<TVehicletype> list = (List<TVehicletype>) result.getRows();
		if (list != null && list.size() > 0) {
			for (TVehicletype tVehicletype : list) {
				CheckBoxVO vo = new CheckBoxVO();
				vo.setId(String.valueOf(tVehicletype.getTypeid()));
				vo.setText(tVehicletype.getTypename());
				checkResult.add(vo);
			}
		}
		return checkResult;
	}

}
