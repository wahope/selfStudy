package com.selfStudy.core.backstage.service;

import com.selfStudy.core.pojo.SsSpecialty;

import java.util.List;

public interface SpecialtyService {
    /**
     * @Description 无条件查询所有专业
     * @author 凌文
     * @date 2019/2/12 9:49
     * @param[]
     * @return java.util.List<com.selfStudy.core.pojo.SsSpecialty>
     */
    List<SsSpecialty> selectAllSpe();
}
