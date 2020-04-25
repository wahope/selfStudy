package com.selfStudy.core.mapper;

import com.selfStudy.core.pojo.SsSpecialty;
import com.selfStudy.core.pojo.SsSpecialtyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsSpecialtyMapper {
    int countByExample(SsSpecialtyExample example);

    int deleteByExample(SsSpecialtyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsSpecialty record);

    int insertSelective(SsSpecialty record);

    List<SsSpecialty> selectByExample(SsSpecialtyExample example);

    SsSpecialty selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsSpecialty record, @Param("example") SsSpecialtyExample example);

    int updateByExample(@Param("record") SsSpecialty record, @Param("example") SsSpecialtyExample example);

    int updateByPrimaryKeySelective(SsSpecialty record);

    int updateByPrimaryKey(SsSpecialty record);

    List<SsSpecialty> selectAllSpe();
}