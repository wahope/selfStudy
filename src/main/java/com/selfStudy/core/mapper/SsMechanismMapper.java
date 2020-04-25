package com.selfStudy.core.mapper;

import com.selfStudy.core.pojo.SsMechanism;
import com.selfStudy.core.pojo.SsMechanismExample;
import java.util.List;

import com.selfStudy.core.pojo.vo.SsMechanismVo;
import org.apache.ibatis.annotations.Param;

public interface SsMechanismMapper {
    int countByExample(SsMechanismExample example);

    int deleteByExample(SsMechanismExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsMechanism record);

    int insertSelective(SsMechanism record);

    List<SsMechanism> selectByExample(SsMechanismExample example);

    SsMechanism selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsMechanism record, @Param("example") SsMechanismExample example);

    int updateByExample(@Param("record") SsMechanism record, @Param("example") SsMechanismExample example);

    int updateByPrimaryKeySelective(SsMechanism record);

    int updateByPrimaryKey(SsMechanism record);

    SsMechanism selectMecById(Integer id);

    List<SsMechanismVo> selectAllMechanism();
}