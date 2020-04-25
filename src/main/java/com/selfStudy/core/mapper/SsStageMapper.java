package com.selfStudy.core.mapper;

import com.selfStudy.core.pojo.SsStage;
import com.selfStudy.core.pojo.SsStageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsStageMapper {
    int countByExample(SsStageExample example);

    int deleteByExample(SsStageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsStage record);

    int insertSelective(SsStage record);

    List<SsStage> selectByExample(SsStageExample example);

    SsStage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsStage record, @Param("example") SsStageExample example);

    int updateByExample(@Param("record") SsStage record, @Param("example") SsStageExample example);

    int updateByPrimaryKeySelective(SsStage record);

    int updateByPrimaryKey(SsStage record);

    /**
     * @Description 根据专业查询所有阶段
     * @author 凌文
     * @date 2019/2/12 11:58
     * @param[specialtyId]
     * @return java.util.List<com.selfStudy.core.pojo.SsStage>
     */
    List<SsStage> selectStageBySpeId(Integer specialtyId);
}