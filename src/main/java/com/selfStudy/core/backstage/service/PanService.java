package com.selfStudy.core.backstage.service;

import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.pojo.SsPan;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：凌文
 * @ClassName PanService
 * @date ：Created in 2019/2/9 16:15
 * @description： 百度网盘业务层
 * @modified By：
 * @version: $
 * @Class:
 */
public interface PanService {
    /**
     * @Description 添加网盘资料
     * @date 2019/2/9 16:21
     * @param[ssPan]
     * @return com.selfStudy.common.ServerRespose
     */
    ServerRespose insertPan(SsPan ssPan);

    /**
     * @Description 根据id删除网盘资料
     * @author 凌文
     * @date 2019/2/9 16:24
     * @param[ssPan]
     * @return com.selfStudy.common.ServerRespose
     */
    ServerRespose delPan(Integer id);

    /**
     * @Description 根据id批量删除
     * @author 凌文
     * @date 2019/2/17 9:06
     * @param[ids]
     * @return void
     */
    void delMorePanById(String ids);

    /**
     * @Description 修改网盘资料
     * @author 凌文
     * @date 2019/2/9 16:24
     * @param[ssPan]
     * @return com.selfStudy.common.ServerRespose
     */
    ServerRespose updatePan(SsPan ssPan);

    /**
     * @Description 根据id查询网盘资料信息
     * @author 凌文
     * @date 2019/2/17 9:35
     * @param[id]
     * @return java.util.List<com.selfStudy.core.pojo.SsPan>
     */
    List<SsPan> selectPanById(Integer id);

    /**
     * @Description 无条件查询，不分页
     * @author 凌文
     * @date 2019/2/17 9:37
     * @param[]
     * @return java.util.List<com.selfStudy.core.pojo.SsPan>
     */
    List<SsPan> selectAllPan();

    /**
     * @Description 无条件查询，分页
     * @author 凌文
     * @date 2019/2/9 16:27
     * @param[pageNum, pageSize]
     * @return com.selfStudy.common.PageResult<com.selfStudy.core.pojo.SsPan>
     */
    PageResult<SsPan> selectAllPan(int pageNum,int pageSize);
}
