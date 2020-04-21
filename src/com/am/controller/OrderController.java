package com.am.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.am.pojo.TOrder;
import com.am.pojo.TOrderdetail;
import com.am.service.OrderService;
import com.am.util.AMResult;
import com.am.util.DateUtil;
import com.am.util.EasyUIResult;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.abel533.echarts.Option;

@Controller
public class OrderController {
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
	private OrderService orderService;

	@RequestMapping("/order/getorders")
	@ResponseBody
	public EasyUIResult getOrder(TOrder tOrder,
			@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "30") Integer rows) {
		return orderService.getOrder(tOrder, page, rows);
	}

	@RequestMapping("/order/addorder")
	@ResponseBody
	public AMResult addOrder(TOrder tOrder) {
		return orderService.addOrder(tOrder);
	}

	@RequestMapping("/order/updateorder")
	@ResponseBody
	public AMResult updateOrder(TOrder tOrder) {
		return orderService.updateOrder(tOrder);
	}

	@RequestMapping("/order/applyeorder")
	@ResponseBody
	public AMResult applyOrder(TOrder tOrder) {
		return orderService.applyOrder(tOrder);
	}

	@RequestMapping("/order/deleteorder")
	@ResponseBody
	public AMResult deleteOrder(Integer orderid) {
		return orderService.deleteOrder(orderid);
	}

	@RequestMapping("/order/getorderdetail")
	@ResponseBody
	public EasyUIResult getOrderdetail(String orderNum) {
		return orderService.getOrderdetail(orderNum);
	}

	@RequestMapping("/order/addorderdetail")
	@ResponseBody
	public AMResult addOrderdetail(TOrderdetail tOrderdetail) {
		return orderService.addOrderdetail(tOrderdetail);
	}

	@RequestMapping("/order/updateorderdetail")
	@ResponseBody
	public AMResult updateOrderdetail(TOrderdetail tOrderdetail) {
		return orderService.updateOrderdetail(tOrderdetail);
	}

	@RequestMapping("/order/deleteorderdetail")
	@ResponseBody
	public AMResult deleteOrderdetail(Integer orderdetailid) {
		return orderService.deleteOrderdetail(orderdetailid);
	}

	@RequestMapping("/order/sumorder")
	@ResponseBody
	public String sumOrder(Date date,@RequestParam(defaultValue = "1") String sumlevel,
			@RequestParam(defaultValue = "1") String pictype,
			@RequestParam(defaultValue = "1") String sumtype) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		String defaultlevel = "1";
		if (sumlevel == null || "".equals(sumlevel)) {
			sumlevel = defaultlevel;
		}
		Date startDate = null;
		Date endDate = null;
		if ("1".equals(sumlevel)) {
			startDate = DateUtil.getFisrtDayOfMonth(date);
			endDate = DateUtil.getLastDayOfMonth(date);
		} else if ("2".equals(sumlevel)) {
			startDate = DateUtil.getCurrentQuarterStartTime(date);
			endDate = DateUtil.getCurrentQuarterEndTime(date);
		} else if ("3".equals(sumlevel)) {
			startDate = DateUtil.getFisrtDayOfYear(date);
			endDate = DateUtil.getLastDayOfYear(date);
		}
		try {
			Option option = orderService.sumOrder(startDate, endDate,pictype,sumtype);
			return mapper.writeValueAsString(AMResult.build(200, "success",
					option));
		} catch (Exception e) {
			e.printStackTrace();
			return mapper.writeValueAsString(AMResult.build(201, "数据获取出错"));
		}
	}
	
	@RequestMapping("/order/orderfinish")
	@ResponseBody
	public AMResult orderFinish(Integer orderid) {
		return orderService.finishOrder(orderid);
	}

}
