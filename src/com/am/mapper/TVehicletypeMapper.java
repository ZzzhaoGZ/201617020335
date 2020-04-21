package com.am.mapper;

import com.am.pojo.TVehicletype;
import com.am.pojo.TVehicletypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TVehicletypeMapper {
    int countByExample(TVehicletypeExample example);

    int deleteByExample(TVehicletypeExample example);

    int deleteByPrimaryKey(Integer typeid);

    int insert(TVehicletype record);

    int insertSelective(TVehicletype record);

    List<TVehicletype> selectByExample(TVehicletypeExample example);

    TVehicletype selectByPrimaryKey(Integer typeid);

    int updateByExampleSelective(@Param("record") TVehicletype record, @Param("example") TVehicletypeExample example);

    int updateByExample(@Param("record") TVehicletype record, @Param("example") TVehicletypeExample example);

    int updateByPrimaryKeySelective(TVehicletype record);

    int updateByPrimaryKey(TVehicletype record);
}