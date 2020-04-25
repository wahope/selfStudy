package com.selfStudy.core.backstage.service.impl;

import com.selfStudy.core.backstage.service.SpecialtyService;
import com.selfStudy.core.mapper.SsSoftwareMapper;
import com.selfStudy.core.mapper.SsSpecialtyMapper;
import com.selfStudy.core.pojo.SsSpecialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/2/12 9:52
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    public SsSpecialtyMapper specialtyMapper;

    @Override
    public List<SsSpecialty> selectAllSpe() {
        List<SsSpecialty> specialtyList = specialtyMapper.selectAllSpe();
        return specialtyList;
    }
}
