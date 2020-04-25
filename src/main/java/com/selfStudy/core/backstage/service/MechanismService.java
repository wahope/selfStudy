package com.selfStudy.core.backstage.service;

import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.pojo.SsMechanism;
import com.selfStudy.core.pojo.vo.SsMechanismVo;

import java.util.List;

public interface MechanismService {
    ServerRespose insertMechanism(SsMechanism ssMechanism);

    ServerRespose delWebById(Integer id);

    void delMoreWebById(String ids);

    ServerRespose updateWebById(SsMechanism mechanism);

    SsMechanism selectMecById(Integer id);

    PageResult<SsMechanismVo> selectAllMechanism(int pageNum, int pageSize);
}
