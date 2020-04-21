package com.am.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.am.pojo.OrderdetailVO;
import com.am.pojo.TOrderdetail;
import com.am.pojo.TOrderdetailExample;

public interface TOrderdetailMapper {
    int countByExample(TOrderdetailExample example);

    int deleteByExample(TOrderdetailExample example);

    int deleteByPrimaryKey(Integer orderdetailid);

    int insert(TOrderdetail record);

    int insertSelective(TOrderdetail record);

    List<TOrderdetail> selectByExample(TOrderdetailExample example);

    TOrderdetail selectByPrimaryKey(Integer orderdetailid);

    int updateByExampleSelective(@Param("record") TOrderdetail record, @Param("example") TOrderdetailExample example);

    int updateByExample(@Param("record") TOrderdetail record, @Param("example") TOrderdetailExample example);

    int updateByPrimaryKeySelective(TOrderdetail record);

    int updateByPrimaryKey(TOrderdetail record);
    
    List<OrderdetailVO> selectOrderdetailByCondition(String orderNum);	
}