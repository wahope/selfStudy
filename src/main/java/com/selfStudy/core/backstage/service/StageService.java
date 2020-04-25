package com.selfStudy.core.backstage.service;

import com.selfStudy.core.pojo.SsStage;

import java.util.List;

/**
 * @author ：凌文
 * @ClassName StageService
 * @date ：Created in 2019/2/12 12:06
 * @description：
 * @modified By：
 * @version: $ 1.0
 * @Class:
 */
public interface StageService {
    /**
     * @Description 根据专业查询所有阶段
     * @author 凌文
     * @date 2019/2/12 11:58
     * @param[specialtyId]
     * @return java.util.List<com.selfStudy.core.pojo.SsStage>
     */
    List<SsStage> selectStageBySpeId(Integer specialtyId);
}
