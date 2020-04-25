package com.selfStudy.core.backstage.service.impl;

import com.selfStudy.core.backstage.service.StageService;
import com.selfStudy.core.mapper.SsStageMapper;
import com.selfStudy.core.pojo.SsStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/2/12 16:23
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Service
public class StageServiceImpl implements StageService {

    @Autowired
    public SsStageMapper stageMapper;

    @Override
    public List<SsStage> selectStageBySpeId(Integer specialtyId) {
        List<SsStage> stageList = stageMapper.selectStageBySpeId(specialtyId);
        return stageList;
    }
}
