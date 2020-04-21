package com.am.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.mapper.TVehicleMapper;
import com.am.mapper.TVehicletypeMapper;
import com.am.pojo.TVehicle;
import com.am.pojo.TVehicleExample;
import com.am.pojo.TVehicletype;
import com.am.pojo.TVehicletypeExample;
import com.am.service.VehicleTypeService;
import com.am.util.AMResult;
import com.am.util.EasyUIResult;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {

	@Autowired
	private TVehicletypeMapper tVehicletypeMapper;

	@Autowired
	private TVehicleMapper tVehicleMapper;

	@Override
	public EasyUIResult getTVehicletypees(TVehicletype tTVehicletypee) {
		TVehicletypeExample example = new TVehicletypeExample();
		List<TVehicletype> list = tVehicletypeMapper.selectByExample(example);
		EasyUIResult result = new EasyUIResult();
		result.setRows(list);
		result.setTotal(list == null ? 0 : list.size());
		return result;
	}

	@Override
	public AMResult addTVehicletypee(TVehicletype tTVehicletypee) {

		// 查询是否重名
		TVehicletypeExample example = new TVehicletypeExample();
		example.createCriteria().andTypenameEqualTo(
				tTVehicletypee.getTypename());
		List list = tVehicletypeMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return AMResult.build(201, "新增失败,名称重复");
		}
		int row = tVehicletypeMapper.insert(tTVehicletypee);
		if (row > 0) {
			return AMResult.build(200, "新增成功");
		}
		return AMResult.build(201, "新增失败");
	}

	@Override
	public AMResult updateTVehicletypee(TVehicletype tTVehicletypee) {
		TVehicletypeExample example = new TVehicletypeExample();
		example.createCriteria()
				.andTypenameEqualTo(tTVehicletypee.getTypename())
				.andTypeidNotEqualTo(tTVehicletypee.getTypeid());
		List list = tVehicletypeMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return AMResult.build(201, "新增失败,名称重复");
		}

		int row = tVehicletypeMapper.updateByPrimaryKey(tTVehicletypee);
		if (row > 0) {
			return AMResult.build(200, "修改成功");
		}
		return AMResult.build(201, "修改失败");
	}

	@Override
	public AMResult deleteTVehicletypee(Integer TVehicletypeeid) {
		TVehicleExample example = new TVehicleExample();
		example.createCriteria().andVehicletypeidEqualTo(TVehicletypeeid);
		List<TVehicle> list = tVehicleMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return AMResult.build(201, "当前类别下有车辆记录，无法删除");
		}
		int row = tVehicletypeMapper.deleteByPrimaryKey(TVehicletypeeid);
		if (row > 0) {
			return AMResult.build(200, "删除成功");
		}
		return AMResult.build(201, "删除失败");
	}

}
