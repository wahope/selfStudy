package com.selfStudy.core.mapper;

import com.selfStudy.core.pojo.SsPan;
import com.selfStudy.core.pojo.SsPanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsPanMapper {
    int countByExample(SsPanExample example);

    int deleteByExample(SsPanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsPan record);

    int insertSelective(SsPan record);

    List<SsPan> selectByExample(SsPanExample example);

    SsPan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsPan record, @Param("example") SsPanExample example);

    int updateByExample(@Param("record") SsPan record, @Param("example") SsPanExample example);

    int updateByPrimaryKeySelective(SsPan record);

    int updateByPrimaryKey(SsPan record);

    /**
     * @Description 无条件查询所有网盘资料
     * @author 凌文
     * @date 2019/2/9 16:09
     * @param[]
     * @return java.util.List<com.selfStudy.core.pojo.SsPan>
     */
    List<SsPan> selectAllPan();
}