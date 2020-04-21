package com.am.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.mapper.TOrderMapper;
import com.am.mapper.TVehicleMapper;
import com.am.pojo.TOrderExample;
import com.am.pojo.TVehicle;
import com.am.pojo.VehicleVO;
import com.am.service.VehicleService;
import com.am.util.AMResult;
import com.am.util.EasyUIResult;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private TVehicleMapper tVehicleMapper;

	@Autowired
	private TOrderMapper tOrderMapper;

	@Override
	public EasyUIResult getVehicles(TVehicle tVehicle) {
		@SuppressWarnings("rawtypes")
		Map param = new HashMap();
		if (tVehicle != null) {
			param.put("vehicleTypeId", tVehicle.getVehicletypeid());
			param.put("vehicleNum", tVehicle.getVehiclenum());
			param.put("vehicleStatus", tVehicle.getVehiclestatus());
		}
		List<VehicleVO> list = tVehicleMapper.selectVehicleByCondition(param);
		EasyUIResult result = new EasyUIResult();
		result.setRows(list);
		result.setTotal(list == null ? 0 : list.size());
		return result;
	}

	@Override
	public AMResult addVehicle(TVehicle tVehicle) {
		int row = tVehicleMapper.insert(tVehicle);
		if(row>0){
			return AMResult.build(200, "新增成功");
		}
		return AMResult.build(201, "新增失败");
	}

	@Override
	public AMResult updateVehicle(TVehicle tVehicle) {
		int row = tVehicleMapper.updateByPrimaryKeySelective(tVehicle);
		if(row>0){
			return AMResult.build(200, "修改成功");
		}
		return AMResult.build(201, "修改失败");
	}

	@Override
	public AMResult deleteVehicle(Integer vehicleid) {

		TOrderExample example = new TOrderExample();
		example.createCriteria().andVehicleidEqualTo(vehicleid);
		List list = tOrderMapper.selectByExample(example );
		if(list!=null&&list.size()>0){
			return AMResult.build(201, "订单记录使用到了该车辆，无法删除");
		}
		
		int row = tVehicleMapper.deleteByPrimaryKey(vehicleid);
		if(row>0){
			return AMResult.build(200, "删除成功");
		}
		return AMResult.build(201, "删除失败");
	}

	@Override
	public AMResult updateVehicleStatus(TVehicle tVehicle) {
		TVehicle old = tVehicleMapper.selectByPrimaryKey(tVehicle.getVehicleid());
		old.setVehiclestatus(tVehicle.getVehiclestatus());
		return null;
	}

}
