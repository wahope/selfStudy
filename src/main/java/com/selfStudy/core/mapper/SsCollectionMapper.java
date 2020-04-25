package com.selfStudy.core.mapper;

import com.selfStudy.core.pojo.SsCollection;
import com.selfStudy.core.pojo.SsCollectionExample;
import java.util.List;

import com.selfStudy.core.pojo.vo.SsCollectionVo;
import org.apache.ibatis.annotations.Param;

public interface SsCollectionMapper {
    int countByExample(SsCollectionExample example);

    int deleteByExample(SsCollectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsCollection record);

    int insertSelective(SsCollection record);

    List<SsCollection> selectByExample(SsCollectionExample example);

    SsCollection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsCollection record, @Param("example") SsCollectionExample example);

    int updateByExample(@Param("record") SsCollection record, @Param("example") SsCollectionExample example);

    int updateByPrimaryKeySelective(SsCollection record);

    int updateByPrimaryKey(SsCollection record);

    List<SsCollectionVo> selectAllCollecte(Integer userId);
}