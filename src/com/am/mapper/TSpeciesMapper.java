package com.am.mapper;

import com.am.pojo.TSpecies;
import com.am.pojo.TSpeciesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSpeciesMapper {
    int countByExample(TSpeciesExample example);

    int deleteByExample(TSpeciesExample example);

    int deleteByPrimaryKey(Integer speciesid);

    int insert(TSpecies record);

    int insertSelective(TSpecies record);

    List<TSpecies> selectByExample(TSpeciesExample example);

    TSpecies selectByPrimaryKey(Integer speciesid);

    int updateByExampleSelective(@Param("record") TSpecies record, @Param("example") TSpeciesExample example);

    int updateByExample(@Param("record") TSpecies record, @Param("example") TSpeciesExample example);

    int updateByPrimaryKeySelective(TSpecies record);

    int updateByPrimaryKey(TSpecies record);
}