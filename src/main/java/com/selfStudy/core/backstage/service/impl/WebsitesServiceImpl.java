package com.selfStudy.core.backstage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.backstage.service.WebsitesService;
import com.selfStudy.core.mapper.SsWebsitesMapper;
import com.selfStudy.core.pojo.SsWebsites;
import com.selfStudy.core.pojo.vo.SsWebsitesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/2/27 9:15
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Service
public class WebsitesServiceImpl implements WebsitesService {

    @Autowired
    public SsWebsitesMapper websitesMapper;

    @Override
    public ServerRespose insertWebsites(SsWebsites ssWebsites) {
        int count = websitesMapper.insert(ssWebsites);
        if (count>0){
            return ServerRespose.CreateBySuccessMessage("添加网站成功！");
        }
        return ServerRespose.CreateByErrorMessage("添加网站失败！");
    }

    @Override
    public ServerRespose delWebById(Integer id) {
        int count = websitesMapper.deleteByPrimaryKey(id);
        if (count>0){
            return ServerRespose.CreateBySuccessMessage("删除网站成功！");
        }
        return ServerRespose.CreateByErrorMessage("删除网站失败！");
    }

    @Override
    public void delMoreWebById(String ids) {
        String[] id = ids.split(",");
        for (String item: id) {
            Integer idd = Integer.parseInt(item);
            websitesMapper.deleteByPrimaryKey(idd);
        }
    }

    @Override
    public ServerRespose updateWebById(SsWebsites ssWebsites) {
        int count = websitesMapper.updateByPrimaryKeySelective(ssWebsites);
        if (count>0){
            return ServerRespose.CreateBySuccessMessage("更新网站成功！");
        }
        return ServerRespose.CreateByErrorMessage("更新网站失败！");
    }

    @Override
    public SsWebsites selectWebById(Integer id) {
        return websitesMapper.selectWebById(id);
    }

    @Override
    public PageResult<SsWebsitesVo> selectAllWebsites(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SsWebsitesVo> websitesVoList = websitesMapper.selectAllWebsites();
        PageInfo pageInfo = new PageInfo<>(websitesVoList);
        return PageResult.ok(websitesVoList,pageInfo.getTotal());
    }
}
