package com.selfStudy.core.mapper;

import com.selfStudy.core.pojo.SsNews;
import com.selfStudy.core.pojo.SsNewsExample;
import java.util.List;

import com.selfStudy.core.pojo.vo.SsNewsVo;
import org.apache.ibatis.annotations.Param;

public interface SsNewsMapper {
    int countByExample(SsNewsExample example);

    int deleteByExample(SsNewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsNews record);

    int insertSelective(SsNews record);

    List<SsNews> selectByExampleWithBLOBs(SsNewsExample example);

    List<SsNews> selectByExample(SsNewsExample example);

    SsNews selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsNews record, @Param("example") SsNewsExample example);

    int updateByExampleWithBLOBs(@Param("record") SsNews record, @Param("example") SsNewsExample example);

    int updateByExample(@Param("record") SsNews record, @Param("example") SsNewsExample example);

    int updateByPrimaryKeySelective(SsNews record);

    int updateByPrimaryKeyWithBLOBs(SsNews record);

    int updateByPrimaryKey(SsNews record);

    List<SsNewsVo> selectAllNews();

    List<SsNews> selectAllNewsUser(Integer sid);

}