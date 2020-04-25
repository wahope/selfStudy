package com.selfStudy.core.backstage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.backstage.service.PanService;
import com.selfStudy.core.mapper.SsPanMapper;
import com.selfStudy.core.pojo.SsPan;
import com.selfStudy.core.pojo.SsPanExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/2/9 16:14
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Service
public class PanServiceImpl implements PanService {

    @Autowired
    public SsPanMapper ssPanMapper;

    @Override
    public ServerRespose insertPan(SsPan ssPan) {
        int count = ssPanMapper.insert(ssPan);
        if(count>0){
            return ServerRespose.CreateBySuccessMessage("网盘资料添加成功！");
        }
        return ServerRespose.CreateByErrorMessage("网盘资料添加失败！");
    }

    @Override
    public ServerRespose delPan(Integer id) {
        int count = ssPanMapper.deleteByPrimaryKey(id);
        if(count>0){
            return ServerRespose.CreateBySuccessMessage("网盘资料删除成功！");
        }
        return ServerRespose.CreateByErrorMessage("网盘资料删除失败！");
    }

    @Override
    public void delMorePanById(String ids) {
        String[] id = ids.split(",");
        for (String temp:id) {
            ssPanMapper.deleteByPrimaryKey(Integer.parseInt(temp));
        }
    }


    @Override
    public ServerRespose updatePan(SsPan ssPan) {
        int count = ssPanMapper.updateByPrimaryKeySelective(ssPan);
        if (count>0){
            return ServerRespose.CreateBySuccessMessage("网盘资料修改成功！");
        }
        return ServerRespose.CreateByErrorMessage("网盘资料修改失败！");
    }

    @Override
    public List<SsPan> selectPanById(Integer id) {
        SsPanExample panExample = new SsPanExample();
        SsPanExample.Criteria criteria = panExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<SsPan> list = ssPanMapper.selectByExample(panExample);
        return list;
    }

    @Override
    public List<SsPan> selectAllPan() {
        return null;
    }

    @Override
    public PageResult<SsPan> selectAllPan(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SsPan> ssPanList = ssPanMapper.selectAllPan();
        PageInfo pageInfo = new PageInfo<>(ssPanList);
        return PageResult.ok(ssPanList,pageInfo.getTotal());
    }
}
