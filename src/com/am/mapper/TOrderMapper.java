package com.am.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.am.pojo.OrderVO;
import com.am.pojo.SumOrderVO;
import com.am.pojo.TOrder;
import com.am.pojo.TOrderExample;

public interface TOrderMapper {
	int countByExample(TOrderExample example);

	int deleteByExample(TOrderExample example);

	int deleteByPrimaryKey(Integer orderid);

	int insert(TOrder record);

	int insertSelective(TOrder record);

	List<TOrder> selectByExample(TOrderExample example);

	TOrder selectByPrimaryKey(Integer orderid);

	int updateByExampleSelective(@Param("record") TOrder record,
			@Param("example") TOrderExample example);

	int updateByExample(@Param("record") TOrder record,
			@Param("example") TOrderExample example);

	int updateByPrimaryKeySelective(TOrder record);

	int updateByPrimaryKey(TOrder record);

	List<OrderVO> selectOrderByCondition(Map param);

	List<SumOrderVO> selectSumOrderByCondition(Map param);

}