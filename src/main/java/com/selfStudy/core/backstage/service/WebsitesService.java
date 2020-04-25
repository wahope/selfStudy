package com.selfStudy.core.backstage.service;

import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.pojo.SsWebsites;
import com.selfStudy.core.pojo.vo.SsWebsitesVo;

import java.util.List;

/**
 * @author ：凌文
 * @ClassName WebsitesService
 * @date ：Created in 2019/2/27 9:08
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
public interface WebsitesService {
    ServerRespose insertWebsites(SsWebsites ssWebsites);

    ServerRespose delWebById(Integer id);

    void delMoreWebById(String ids);

    ServerRespose updateWebById(SsWebsites ssWebsites);

    SsWebsites selectWebById (Integer id);

    PageResult<SsWebsitesVo> selectAllWebsites(int pageSum, int pageSize);
}
