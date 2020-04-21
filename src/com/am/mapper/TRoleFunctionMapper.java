package com.am.mapper;

import com.am.pojo.TRoleFunction;
import com.am.pojo.TRoleFunctionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRoleFunctionMapper {
    int countByExample(TRoleFunctionExample example);

    int deleteByExample(TRoleFunctionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TRoleFunction record);

    int insertSelective(TRoleFunction record);

    List<TRoleFunction> selectByExample(TRoleFunctionExample example);

    TRoleFunction selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TRoleFunction record, @Param("example") TRoleFunctionExample example);

    int updateByExample(@Param("record") TRoleFunction record, @Param("example") TRoleFunctionExample example);

    int updateByPrimaryKeySelective(TRoleFunction record);

    int updateByPrimaryKey(TRoleFunction record);
}