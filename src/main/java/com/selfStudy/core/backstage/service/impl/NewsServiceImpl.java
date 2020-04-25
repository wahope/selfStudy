package com.selfStudy.core.backstage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.backstage.service.NewsSerrvice;
import com.selfStudy.core.mapper.SsNewsMapper;
import com.selfStudy.core.pojo.SsNews;
import com.selfStudy.core.pojo.vo.SsNewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/3/2 15:43
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Service
public class NewsServiceImpl implements NewsSerrvice {

    @Autowired
    public SsNewsMapper newsMapper;

    @Override
    public ServerRespose insertNews(SsNews news) {
       int count = newsMapper.insert(news);
        if(count>0){
            ServerRespose.CreateBySuccessMessage("新闻动态添加成功！");
        }
        return ServerRespose.CreateByErrorMessage("新闻动态添加失败！");
    }

    @Override
    public ServerRespose delNewsById(Integer id) {
        int count = newsMapper.deleteByPrimaryKey(id);
        if(count>0){
            ServerRespose.CreateBySuccessMessage("新闻动态删除成功！");
        }
        return ServerRespose.CreateByErrorMessage("新闻动态删除失败！");
    }

    @Override
    public void delMoreNewsById(String ids) {
        String[] id = ids.split(",");
        for (String item:id) {
            newsMapper.deleteByPrimaryKey(Integer.parseInt(item));
        }
    }

    @Override
    public ServerRespose updateNewsById(SsNews news) {
        int count = newsMapper.updateByPrimaryKeySelective(news);
        if(count>0){
            ServerRespose.CreateBySuccessMessage("更新新闻成功！");
        }
        return ServerRespose.CreateByErrorMessage("更新失败！");
    }

    @Override
    public SsNews selectNewsById(Integer id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult<SsNewsVo> selectAllNews(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SsNewsVo> newsVoList = newsMapper.selectAllNews();
        PageInfo pageInfo = new PageInfo(newsVoList);
        return PageResult.ok(newsVoList,pageInfo.getTotal());
    }
}
