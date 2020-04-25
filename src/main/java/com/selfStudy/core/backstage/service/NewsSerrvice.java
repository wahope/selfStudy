package com.selfStudy.core.backstage.service;

import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.pojo.SsMechanism;
import com.selfStudy.core.pojo.SsNews;
import com.selfStudy.core.pojo.vo.SsMechanismVo;
import com.selfStudy.core.pojo.vo.SsNewsVo;

public interface NewsSerrvice {
    ServerRespose insertNews(SsNews news);

    ServerRespose delNewsById(Integer id);

    void delMoreNewsById(String ids);

    ServerRespose updateNewsById(SsNews news);

    SsNews selectNewsById(Integer id);

    PageResult<SsNewsVo> selectAllNews(int pageNum, int pageSize);
}
