package com.am.mapper;

import com.am.pojo.TRoute;
import com.am.pojo.TRouteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRouteMapper {
    int countByExample(TRouteExample example);

    int deleteByExample(TRouteExample example);

    int deleteByPrimaryKey(Integer routeid);

    int insert(TRoute record);

    int insertSelective(TRoute record);

    List<TRoute> selectByExample(TRouteExample example);

    TRoute selectByPrimaryKey(Integer routeid);

    int updateByExampleSelective(@Param("record") TRoute record, @Param("example") TRouteExample example);

    int updateByExample(@Param("record") TRoute record, @Param("example") TRouteExample example);

    int updateByPrimaryKeySelective(TRoute record);

    int updateByPrimaryKey(TRoute record);
}