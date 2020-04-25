package com.selfStudy.core.frontdesk.service;

import com.github.pagehelper.PageInfo;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.mapper.SsNewsMapper;
import com.selfStudy.core.pojo.SsNews;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/4/1 17:23
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
public interface UserNewsService {
    ServerRespose<PageInfo> selectAllNewsUser(int pageNum, int pageSize,Integer sid);

    ServerRespose selectNewsById(Integer id);
}
