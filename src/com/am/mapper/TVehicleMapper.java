package com.am.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.am.pojo.TVehicle;
import com.am.pojo.TVehicleExample;
import com.am.pojo.VehicleVO;

public interface TVehicleMapper {
    int countByExample(TVehicleExample example);

    int deleteByExample(TVehicleExample example);

    int deleteByPrimaryKey(Integer vehicleid);

    int insert(TVehicle record);

    int insertSelective(TVehicle record);

    List<TVehicle> selectByExample(TVehicleExample example);

    TVehicle selectByPrimaryKey(Integer vehicleid);

    int updateByExampleSelective(@Param("record") TVehicle record, @Param("example") TVehicleExample example);

    int updateByExample(@Param("record") TVehicle record, @Param("example") TVehicleExample example);

    int updateByPrimaryKeySelective(TVehicle record);

    int updateByPrimaryKey(TVehicle record);
    
    List<VehicleVO> selectVehicleByCondition(Map param);
}