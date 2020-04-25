package com.selfStudy.core.backstage.service.impl;

import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.backstage.service.SoftwareService;
import com.selfStudy.core.mapper.SsSoftwareMapper;
import com.selfStudy.core.pojo.SsSoftware;
import com.selfStudy.core.pojo.SsSoftwareExample;
import com.selfStudy.core.pojo.vo.SsSoftwareVo;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;



import java.util.List;

/**
 * @author ：凌文
 * @ClassName SoftwareServiceImpl
 * @date ：Created in 2019/2/1 15:52
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Service
public class SoftwareServiceImpl implements SoftwareService {

    @Autowired
    public SsSoftwareMapper ssSoftwareMapper;
    @Override
    public ServerRespose insertSoftware(SsSoftware ssSoftware) {
        int count = ssSoftwareMapper.insertSelective(ssSoftware);
        if(count>0){
            return ServerRespose.CreateBySuccessMessage("软件添加成功！");
        }
        return ServerRespose.CreateByErrorMessage("软件添加失败！");
    }

    @Override
    public ServerRespose delSofById(Integer id) {
        int count  = ssSoftwareMapper.deleteByPrimaryKey(id);
        if(count>0){
            return ServerRespose.CreateBySuccessMessage("软件删除成功！");
        }
        return ServerRespose.CreateByErrorMessage("软件删除失败！");
    }

    @Override
    public void delMoreSofById(String ids) {
        String[] id = ids.split(",");
        for (String temp:id) {
            int sofId = Integer.parseInt(temp);
            Integer idd = new Integer(sofId);
            ssSoftwareMapper.deleteByPrimaryKey(idd);
        }
    }

    @Override
    public ServerRespose updateSoftware(SsSoftware ssSoftware) {
        int count = ssSoftwareMapper.updateByPrimaryKeySelective(ssSoftware);
        if(count>0){
            return ServerRespose.CreateBySuccessMessage("软件修改成功！");
        }
        return ServerRespose.CreateByErrorMessage("软件修改失败！");
    }

    @Override
    public List<SsSoftware> selectSofById(Integer id) {
        List<SsSoftware> softwareList = ssSoftwareMapper.selectSofById(id);
        return softwareList;
    }

    @Override
    public PageResult<SsSoftwareVo> selectAllSoftware(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SsSoftwareVo> ssSoftwareList = ssSoftwareMapper.selectAllSoftware();
        PageInfo pageInfo = new PageInfo<>(ssSoftwareList);
        return PageResult.ok(ssSoftwareList,pageInfo.getTotal());
    }

    @Override
    public List<SsSoftwareVo> selectAllSoftware() {
        List<SsSoftwareVo> softwareVoList = ssSoftwareMapper.selectAllSoftware();
        return softwareVoList;
    }

    @Override
    public PageResult<SsSoftwareVo> selectSofByStageId(int stageid, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SsSoftwareVo> ssSoftwareList = ssSoftwareMapper.selectSofByStageId(stageid, pageNum, pageSize);
        PageInfo<SsSoftwareVo> pageInfo = new PageInfo<>(ssSoftwareList);
        return PageResult.ok(ssSoftwareList,pageInfo.getTotal());
    }

}
