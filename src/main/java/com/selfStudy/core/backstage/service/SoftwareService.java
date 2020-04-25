package com.selfStudy.core.backstage.service;

import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.pojo.SsSoftware;
import com.selfStudy.core.pojo.vo.SsSoftwareVo;

import java.util.List;

public interface SoftwareService {

    /**
     * @Description 添加软件信息
     * @author 凌文
     * @date 2019/2/1 15:39
     * @param[ssSoftware]
     * @return com.selfStudy.common.ServerRespose
     */
    ServerRespose insertSoftware(SsSoftware ssSoftware);

    /**
     * @Description 根据id删除软件
     * @author 凌文
     * @date 2019/2/1 15:40
     * @param[id]
     * @return com.selfStudy.common.ServerRespose
     */
    ServerRespose delSofById(Integer id);

    /**
     * @Description 根据id批量删除软件
     * @author 凌文
     * @date 2019/2/15 10:53
     * @param[ids]
     * @return com.selfStudy.common.ServerRespose
     */
    void delMoreSofById(String ids);

    /**
     * @Description 修改软件信息
     * @author 凌文
     * @date 2019/2/1 15:41
     * @param[ssSoftware]
     * @return com.selfStudy.common.ServerRespose
     */
    ServerRespose updateSoftware(SsSoftware ssSoftware);

    /**
     * @Description 根据id查软件
     * @author 凌文
     * @date 2019/2/1 15:47
     * @param[id]
     * @return java.util.List
     */
    List<SsSoftware> selectSofById(Integer id);

    /**
     * @Description 无条件查询分页
     * @author 凌文
     * @date 2019/2/1 15:49
     * @param[]
     * @return com.selfStudy.common.PageResult
     */
    PageResult<SsSoftwareVo> selectAllSoftware(int pageNum,int pageSize);

    /**
     * @Description 无条件查询不分页
     * @author 凌文
     * @date 2019/2/3 10:48
     * @param[]
     * @return java.util.List<com.selfStudy.core.pojo.SsSoftware>
     */
    List<SsSoftwareVo> selectAllSoftware();

    /**
     * @Description 根据专业的阶段进行查询分页
     * @author 凌文
     * @date 2019/2/2 8:41
     * @param[stage_id, pageNum, pageSize]
     * @return com.selfStudy.common.PageResult<com.selfStudy.core.pojo.SsSoftware>
     */
    PageResult<SsSoftwareVo> selectSofByStageId(int stageid,int pageNum, int pageSize);
}
