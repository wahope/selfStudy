package com.selfStudy.core.mapper;

import com.selfStudy.core.pojo.SsPic;
import com.selfStudy.core.pojo.SsPicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsPicMapper {
    int countByExample(SsPicExample example);

    int deleteByExample(SsPicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsPic record);

    int insertSelective(SsPic record);

    List<SsPic> selectByExample(SsPicExample example);

    SsPic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsPic record, @Param("example") SsPicExample example);

    int updateByExample(@Param("record") SsPic record, @Param("example") SsPicExample example);

    int updateByPrimaryKeySelective(SsPic record);

    int updateByPrimaryKey(SsPic record);
}