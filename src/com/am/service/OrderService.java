package com.am.service;

import java.util.Date;

import com.am.pojo.TOrder;
import com.am.pojo.TOrderdetail;
import com.am.util.AMResult;
import com.am.util.EasyUIResult;
import com.github.abel533.echarts.Option;

public interface OrderService {

	public EasyUIResult getOrder(TOrder tOrder,Integer page, Integer rows);

	public AMResult addOrder(TOrder tOrder);

	public AMResult updateOrder(TOrder tOrder);

	public AMResult deleteOrder(Integer orderid);
	
	public EasyUIResult getOrderdetail(String orderNum);
	
	public AMResult addOrderdetail(TOrderdetail tOrderdetail);
	
	public AMResult updateOrderdetail(TOrderdetail tOrderdetail);
	
	public AMResult deleteOrderdetail(Integer orderdetailid);

	public AMResult applyOrder(TOrder tOrder);
	
	public Option sumOrder(Date beginDate, Date endDate, String pictype,String sumtype);

	public AMResult finishOrder(Integer orderid);
	
	
	

}
