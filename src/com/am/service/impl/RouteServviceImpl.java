package com.am.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.mapper.TOrderMapper;
import com.am.mapper.TRouteMapper;
import com.am.pojo.TOrder;
import com.am.pojo.TOrderExample;
import com.am.pojo.TRoute;
import com.am.pojo.TRouteExample;
import com.am.service.RouteService;
import com.am.util.AMResult;
import com.am.util.EasyUIResult;

@Service
public class RouteServviceImpl implements RouteService {

	@Autowired
	private TRouteMapper tRouteMapper;

	@Autowired
	private TOrderMapper tOrderMapper;

	@Override
	public EasyUIResult getRoute(TRoute tRoute) {
		TRouteExample example = new TRouteExample();
		if (tRoute != null) {
			if (tRoute.getRoutename() != null
					&& !"".equals(tRoute.getRoutename())) {
				example.createCriteria()
						.andRoutenameLike("%"+tRoute.getRoutename()+"%");
			}
		}
		List<TRoute> list = tRouteMapper.selectByExample(example);
		EasyUIResult result = new EasyUIResult();
		result.setRows(list);
		result.setTotal(list == null ? 0 : list.size());
		return result;
	}

	@Override
	public AMResult addRoute(TRoute tRoute) {
		int row = tRouteMapper.insert(tRoute);
		if (row > 0) {
			return AMResult.build(200, "新增成功");
		}
		return AMResult.build(201, "新增失败");
	}

	@Override
	public AMResult updateRoute(TRoute tRoute) {
		int row = tRouteMapper.updateByPrimaryKeySelective(tRoute);
		if (row > 0) {
			return AMResult.build(200, "新增成功");
		}
		return AMResult.build(201, "新增失败");
	}

	@Override
	public AMResult deleteRoute(Integer routeid) {
		TOrderExample example = new TOrderExample();
		example.createCriteria().andRouteidEqualTo(routeid);
		List<TOrder> list = tOrderMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return AMResult.build(201, "请先删除使用此路线的订单");
		}
		int row = tRouteMapper.deleteByPrimaryKey(routeid);
		if (row > 0) {
			return AMResult.build(200, "删除成功");
		}
		return AMResult.build(201, "删除失败");
	}

}
