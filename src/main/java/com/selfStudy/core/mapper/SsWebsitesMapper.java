package com.selfStudy.core.mapper;

import com.selfStudy.core.pojo.SsWebsites;
import com.selfStudy.core.pojo.SsWebsitesExample;
import java.util.List;

import com.selfStudy.core.pojo.vo.SsWebsitesVo;
import org.apache.ibatis.annotations.Param;

public interface SsWebsitesMapper {
    int countByExample(SsWebsitesExample example);

    int deleteByExample(SsWebsitesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsWebsites record);

    int insertSelective(SsWebsites record);

    List<SsWebsites> selectByExample(SsWebsitesExample example);

    SsWebsites selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsWebsites record, @Param("example") SsWebsitesExample example);

    int updateByExample(@Param("record") SsWebsites record, @Param("example") SsWebsitesExample example);

    int updateByPrimaryKeySelective(SsWebsites record);

    int updateByPrimaryKey(SsWebsites record);

    /**
     * @Description 无条件查询所有网站
     * @author 凌文
     * @date 2019/2/27 9:03
     * @param[]
     * @return java.util.List<com.selfStudy.core.pojo.vo.SsWebsitesVo>
     */
    List<SsWebsitesVo> selectAllWebsites();

//    List<SsWebsites> selectWebById(Integer id);

    SsWebsites selectWebById(Integer id);
}