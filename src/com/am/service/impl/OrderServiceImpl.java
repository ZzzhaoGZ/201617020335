package com.am.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.mapper.TItemMapper;
import com.am.mapper.TOrderMapper;
import com.am.mapper.TOrderdetailMapper;
import com.am.mapper.TVehicleMapper;
import com.am.pojo.OrderVO;
import com.am.pojo.OrderdetailVO;
import com.am.pojo.SumOrderVO;
import com.am.pojo.TItem;
import com.am.pojo.TOrder;
import com.am.pojo.TOrderdetail;
import com.am.pojo.TOrderdetailExample;
import com.am.pojo.TVehicle;
import com.am.service.OrderService;
import com.am.util.AMResult;
import com.am.util.EasyUIResult;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Pie;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private TOrderMapper tOrderMapper;

	@Autowired
	private TOrderdetailMapper tOrderdetailMapper;

	@Autowired
	private TItemMapper tItemMapper;

	@Autowired
	private TVehicleMapper tVehicleMapper;

	@Override
	public EasyUIResult getOrder(TOrder tOrder, Integer page, Integer rows) {

		@SuppressWarnings("rawtypes")
		Map param = new HashMap();
		if (tOrder != null) {
			param.put("orderNum", tOrder.getOrdernum());
			param.put("orderStatus", tOrder.getOrderstatus());
		}
		// 设置分页
		PageHelper.startPage(page, rows);
		List<OrderVO> list = tOrderMapper.selectOrderByCondition(param);
		// 取分页信息
		PageInfo<OrderVO> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		EasyUIResult result = new EasyUIResult(total, list);
		return result;

	}

	@Override
	public AMResult addOrder(TOrder tOrder) {
		tOrder.setOrdercreate(new Date());
		tOrder.setOrderstatus("1");
		
		
			BigDecimal orderweight = BigDecimal.ZERO;
			BigDecimal ordercurrency = BigDecimal.ZERO;
			String orderNum = tOrder.getOrdernum();
			List<OrderdetailVO> detailList = tOrderdetailMapper
					.selectOrderdetailByCondition(orderNum);
			if (detailList != null && detailList.size() > 0) {
				for (TOrderdetail tOrderdetail : detailList) {
					orderweight = orderweight
							.add(tOrderdetail.getOrderweight() == null ? BigDecimal.ZERO
									: tOrderdetail.getOrderweight());
					ordercurrency = ordercurrency.add(tOrderdetail
							.getOrdercurrency() == null ? BigDecimal.ZERO
							: tOrderdetail.getOrdercurrency());
				}
			
			tOrder.setOrdercurrency(ordercurrency);
			tOrder.setOrderweight(orderweight);
			int row = tOrderMapper.insert(tOrder);
			if (row > 0) {
				return AMResult.build(200, "新增成功", tOrder);
			}
		}
		return AMResult.build(201, "订单新增失败");
	}

	@Override
	public AMResult updateOrder(TOrder tOrder) {

		BigDecimal orderweight = BigDecimal.ZERO;
		BigDecimal ordercurrency = BigDecimal.ZERO;
		String orderNum = tOrder.getOrdernum();
		List<OrderdetailVO> detailList = tOrderdetailMapper
				.selectOrderdetailByCondition(orderNum);
		if (detailList != null && detailList.size() > 0) {
			for (TOrderdetail tOrderdetail : detailList) {
				orderweight = orderweight
						.add(tOrderdetail.getOrderweight() == null ? BigDecimal.ZERO
								: tOrderdetail.getOrderweight());
				ordercurrency = ordercurrency.add(tOrderdetail
						.getOrdercurrency() == null ? BigDecimal.ZERO
						: tOrderdetail.getOrdercurrency());
			}
		}
		tOrder.setOrdercurrency(ordercurrency);
		tOrder.setOrderweight(orderweight);
		int row = tOrderMapper.updateByPrimaryKeySelective(tOrder);
		if (row > 0) {
			return AMResult.build(200, "订单修改成功");
		}
		return AMResult.build(201, "订单新增失败");
	}

	@Override
	public AMResult deleteOrder(Integer orderid) {
		TOrder tOrder = tOrderMapper.selectByPrimaryKey(orderid);
		if (tOrder != null) {
			TOrderdetailExample deexample = new TOrderdetailExample();
			deexample.createCriteria().andOrdernumEqualTo(tOrder.getOrdernum());
			tOrderdetailMapper.deleteByExample(deexample);
		}
		int row = tOrderMapper.deleteByPrimaryKey(orderid);
		if (row > 0) {
			return AMResult.build(200, "删除成功");
		}
		return AMResult.build(201, "删除失败");
	}

	@Override
	public EasyUIResult getOrderdetail(String orderNum) {
		List<OrderdetailVO> list = tOrderdetailMapper
				.selectOrderdetailByCondition(orderNum);
		EasyUIResult result = new EasyUIResult();
		result.setRows(list);
		result.setTotal(list == null ? 0 : list.size());
		return result;
	}

	@Override
	public AMResult addOrderdetail(TOrderdetail tOrderdetail) {

		long itemid = tOrderdetail.getItemid();
		TItem item = tItemMapper.selectByPrimaryKey(itemid);
		if (item != null) {
			long price = item.getPrice();
			BigDecimal weight = item.getWeight();
			int acount = tOrderdetail.getItemnum();
			BigDecimal ordercurrency = BigDecimal.ZERO;
			ordercurrency = BigDecimal.valueOf(price).multiply(
					BigDecimal.valueOf(acount));
			tOrderdetail.setOrdercurrency(ordercurrency);
			BigDecimal orderweight = BigDecimal.ZERO;
			orderweight = weight.multiply(BigDecimal.valueOf(acount));
			tOrderdetail.setOrderweight(orderweight);
			int row = tOrderdetailMapper.insert(tOrderdetail);
			if (row > 0) {
				return AMResult.build(200, "添加成功");
			}
		}

		return AMResult.build(201, "添加失败");
	}

	@Override
	public AMResult updateOrderdetail(TOrderdetail tOrderdetail) {

		int row = tOrderdetailMapper.updateByPrimaryKey(tOrderdetail);
		if (row > 0) {
			long itemid = tOrderdetail.getItemid();
			TItem item = tItemMapper.selectByPrimaryKey(itemid);
			if (item != null) {
				long price = item.getPrice();
				BigDecimal weight = item.getWeight();
				int acount = tOrderdetail.getItemnum();
				BigDecimal ordercurrency = BigDecimal.ZERO;
				ordercurrency = BigDecimal.valueOf(price).multiply(
						BigDecimal.valueOf(acount));
				tOrderdetail.setOrdercurrency(ordercurrency);
				BigDecimal orderweight = BigDecimal.ZERO;
				orderweight = weight.multiply(BigDecimal.valueOf(acount));
				tOrderdetail.setOrderweight(orderweight);
				int row1 = tOrderdetailMapper.insert(tOrderdetail);
				if (row1 > 0) {
					return AMResult.build(200, "修改成功");
				}
			}
		}
		return AMResult.build(201, "修改失败");
	}

	@Override
	public AMResult deleteOrderdetail(Integer orderdetailid) {
		int row = tOrderdetailMapper.deleteByPrimaryKey(orderdetailid);
		if (row > 0) {
			return AMResult.build(200, "删除成功");
		}
		return AMResult.build(201, "删除失败");
	}

	@Override
	public AMResult applyOrder(TOrder tOrder) {

		Integer vehicleid = tOrder.getVehicleid();
		Integer routeid = tOrder.getRouteid();
		tOrder = tOrderMapper.selectByPrimaryKey(tOrder.getOrderid());

		TVehicle tVehicle = tVehicleMapper.selectByPrimaryKey(vehicleid);
		if (tVehicle == null) {
			return AMResult.build(201, "车辆信息不存在");
		}
		BigDecimal vweight = tVehicle.getVehicleload();
		BigDecimal oweight = tOrder.getOrderweight();
		if (vweight.compareTo(oweight) < 0) {
			return AMResult.build(201, "车辆载重小于订单总重，请重新选择车辆或添加车辆信息");
		}
		tOrder.setVehicleid(vehicleid);
		tOrder.setRouteid(routeid);
		tOrder.setOrderstatus("2");
		tOrderMapper.updateByPrimaryKey(tOrder);
		return AMResult.build(200, "车辆，路线分配完成");
	}

	@Override
	public Option sumOrder(Date beginDate, Date endDate, String pictype, String sumtype) {

		@SuppressWarnings("rawtypes")
		Map param = new HashMap();
		param.put("beginDate", beginDate);
		param.put("endDate", endDate);
		List<SumOrderVO> list = tOrderMapper.selectSumOrderByCondition(param);
		// 创建Option
		Option option = new Option();
		String title = "金额（元）";
		if("1".equals(sumtype)){
			title = "金额（元）";
		}else{
			title = "数量";
		}
		
		
		// 绘制柱状图
		if ("1".equals(pictype)) {
			option.title("商品").tooltip(Trigger.axis).legend(title);
			// 横轴为值轴
			option.yAxis(new ValueAxis().boundaryGap(0d, 0.01));
			// 创建类目轴
			CategoryAxis category = new CategoryAxis();
			// 柱状数据
			Bar bar = new Bar(title);
			// 循环数据
			for (SumOrderVO sumOrderVO : list) {
				// 设置类目
				category.data(sumOrderVO.getItemname());
				// 类目对应的柱状图
				if ("2".equals(sumtype)) {
					bar.data(sumOrderVO.getItemnum());
				} else if ("1".equals(sumtype)) {
					bar.data(sumOrderVO.getItemcurrency());
				}

			}
			// 设置类目轴
			option.xAxis(category);
			// 设置数据
			option.series(bar);
			// 由于药品名字过长，图表距离左侧距离设置180，关于grid可以看ECharts的官方文档
			option.grid().x(180);
			// 返回Option
			return option;
		} else{
			option.title("商品").tooltip(Trigger.axis).legend(title);
			// 横轴为值轴
			option.xAxis(new ValueAxis().boundaryGap(0d, 0.01));
			// 饼图数据
			Pie pie = new Pie(title);
			// 循环数据
			for (SumOrderVO sumOrderVO : list) {
				// 饼图数据
				// 类目对应的柱状图
				if ("2".equals(sumtype)) {
					pie.data(new PieData(sumOrderVO.getItemname()+"("+sumOrderVO
							.getItemnum()+")", sumOrderVO.getItemnum()));
				} else if ("1".equals(sumtype)) {
					pie.data(new PieData(sumOrderVO.getItemname()+"("+sumOrderVO.getItemcurrency()+")", sumOrderVO
							.getItemcurrency()));
				}

			}
			// 饼图的圆心和半径
			pie.center(550, 350).radius(200);
			// 设置数据
			option.series(pie);
			// 由于药品名字过长，图表距离左侧距离设置180，关于grid可以看ECharts的官方文档
			option.grid().x(180);
			// 返回Option
			return option;
		}
	}

	@Override
	public AMResult finishOrder(Integer orderid) {
		TOrder torder = tOrderMapper.selectByPrimaryKey(orderid);
		if(torder!=null){
			torder.setOrderstatus("3");
			int row = tOrderMapper.updateByPrimaryKey(torder);
			if(row>0){
				return AMResult.build(200,"更新成功");
			}else{
				return AMResult.build(201, "更新失败");
			}
		}
		return AMResult.build(201, "记录不存在！刷新重试");
	}
}
