package com.selfStudy.core.mapper;

import com.selfStudy.core.pojo.SsBook;
import com.selfStudy.core.pojo.SsBookExample;
import com.selfStudy.core.pojo.SsBookWithBLOBs;
import java.util.List;

import com.selfStudy.core.pojo.vo.SsBookVo;
import com.selfStudy.core.pojo.vo.UserSourceVo;
import org.apache.ibatis.annotations.Param;

public interface SsBookMapper {
    int countByExample(SsBookExample example);

    int deleteByExample(SsBookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsBook record);

    int insertSelective(SsBookWithBLOBs record);

    List<SsBookWithBLOBs> selectByExampleWithBLOBs(SsBookExample example);

    List<SsBook> selectByExample(SsBookExample example);

    SsBook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsBookWithBLOBs record, @Param("example") SsBookExample example);

    int updateByExampleWithBLOBs(@Param("record") SsBookWithBLOBs record, @Param("example") SsBookExample example);

    int updateByExample(@Param("record") SsBook record, @Param("example") SsBookExample example);

    int updateByPrimaryKeySelective(SsBook record);

    int updateByPrimaryKeyWithBLOBs(SsBookWithBLOBs record);

    int updateByPrimaryKey(SsBook record);

    List<SsBookVo> selectAllBook();

    List<SsBook> selectAllBookByStaId(Integer id);

    List<UserSourceVo> selectSourceByStaId(Integer id);

    SsBook selectBookById(Integer id);
}