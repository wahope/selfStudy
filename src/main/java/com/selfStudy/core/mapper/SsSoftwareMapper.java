package com.selfStudy.core.mapper;

import com.selfStudy.core.pojo.SsSoftware;
import com.selfStudy.core.pojo.SsSoftwareExample;
import java.util.List;

import com.selfStudy.core.pojo.vo.SsSoftwareVo;
import org.apache.ibatis.annotations.Param;

public interface SsSoftwareMapper {
    int countByExample(SsSoftwareExample example);

    int deleteByExample(SsSoftwareExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsSoftware record);

    int insertSelective(SsSoftware record);

    List<SsSoftware> selectByExample(SsSoftwareExample example);

    SsSoftware selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsSoftware record, @Param("example") SsSoftwareExample example);

    int updateByExample(@Param("record") SsSoftware record, @Param("example") SsSoftwareExample example);

    int updateByPrimaryKeySelective(SsSoftware record);

    int updateByPrimaryKey(SsSoftware record);
    
    /**
     * @Description 无条件查询
     * @author 凌文
     * @date 2019/2/1 17:08
     * @param
     * @return java.util.List<com.selfStudy.core.pojo.SsSoftware>
     */
    List<SsSoftwareVo> selectAllSoftware();
    /**
     * @Description 根据软件主键id查询
     * @author 凌文
     * @date 2019/2/2 9:55
     * @param[id]
     * @return java.util.List<com.selfStudy.core.pojo.SsSoftware>
     */
    List<SsSoftware> selectSofById(Integer id);

    /**
     * @Description 根据专业的阶段id查询并分页
     * @author 凌文
     * @date 2019/2/1 18:35
     * @param[stage_id, pageNum, pageSize]
     * @return java.util.List<com.selfStudy.core.pojo.SsSoftware>
     */
    List<SsSoftwareVo> selectSofByStageId(int stageid, int pageNum, int pageSize);


}