package com.selfStudy.core.backstage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.backstage.service.MechanismService;
import com.selfStudy.core.mapper.SsMechanismMapper;
import com.selfStudy.core.pojo.SsMechanism;
import com.selfStudy.core.pojo.vo.SsMechanismVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/2/28 15:23
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Service
public class MechanismServiceImpl implements MechanismService {
    @Autowired
    public SsMechanismMapper mechanismMapper;

    @Override
    public ServerRespose insertMechanism(SsMechanism ssMechanism) {
        int count = mechanismMapper.insert(ssMechanism);
        if(count>0){
            ServerRespose.CreateBySuccessMessage("添加相关机构成功！");
        }
        return ServerRespose.CreateByErrorMessage("添加失败！");
    }

    @Override
    public ServerRespose delWebById(Integer id) {
        int count = mechanismMapper.deleteByPrimaryKey(id);
        if(count>0){
            ServerRespose.CreateBySuccessMessage("删除相关机构成功！");
        }
        return ServerRespose.CreateByErrorMessage("删除失败！");
    }

    @Override
    public void delMoreWebById(String ids) {
        String[] id = ids.split(",");
        for (String item:id) {
            mechanismMapper.deleteByPrimaryKey(Integer.parseInt(item));
        }
    }

    @Override
    public ServerRespose updateWebById(SsMechanism mechanism) {
        int count = mechanismMapper.updateByPrimaryKeySelective(mechanism);
        if(count>0){
            ServerRespose.CreateBySuccessMessage("更新相关机构成功！");
        }
        return ServerRespose.CreateByErrorMessage("更新失败！");
    }

    @Override
    public SsMechanism selectMecById(Integer id) {
        return mechanismMapper.selectMecById(id);
    }

    @Override
    public PageResult<SsMechanismVo> selectAllMechanism(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SsMechanismVo> mechanismVoList = mechanismMapper.selectAllMechanism();
        PageInfo pageInfo = new PageInfo(mechanismVoList);
        return PageResult.ok(mechanismVoList,pageInfo.getTotal());
    }
}
