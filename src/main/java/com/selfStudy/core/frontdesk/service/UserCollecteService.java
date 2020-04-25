package com.selfStudy.core.frontdesk.service;

import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.pojo.SsCollection;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/4/9 11:35
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
public interface UserCollecteService {
    ServerRespose insertCollecte(Integer userId,String sourceIds);
    ServerRespose delCollectById(Integer id);
    ServerRespose selectAllCollecte(int pageNum, int limit,Integer userId);
}
