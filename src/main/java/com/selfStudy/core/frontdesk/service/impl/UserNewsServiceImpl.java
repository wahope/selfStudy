package com.selfStudy.core.frontdesk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.frontdesk.service.UserNewsService;
import com.selfStudy.core.mapper.SsNewsMapper;
import com.selfStudy.core.pojo.SsNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：凌文
 * @ClassName NewsServiceImpl
 * @date ：Created in 2019/4/1 17:23
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Service
public class UserNewsServiceImpl implements UserNewsService {
    @Autowired
    private SsNewsMapper newsMapper;

    @Override
    public ServerRespose<PageInfo> selectAllNewsUser(int pageNum, int pageSize,Integer sid) {
        PageHelper.startPage(pageNum,pageSize);
        List<SsNews> list = newsMapper.selectAllNewsUser(sid);
        if(list.size()==0){
            return ServerRespose.CreateByErrorMessage("很抱歉，没有数据！");
        }
        PageInfo pageInfo = new PageInfo<SsNews>(list);
        return ServerRespose.CreateBySuccess(pageInfo);
    }

    @Override
    public ServerRespose selectNewsById(Integer id) {
        ServerRespose serverRespose = ServerRespose.CreateBySuccess(newsMapper.selectByPrimaryKey(id));
        return serverRespose;
    }
}
