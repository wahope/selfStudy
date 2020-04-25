package com.selfStudy.core.frontdesk.service;

import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.pojo.SsBook;

import java.util.List;

public interface UserBookService {
    ServerRespose selectAllBookByStaId (int pageNum,int limit,Integer stageId);
    ServerRespose selectSourceByStaId (Integer stageId);
    ServerRespose selectBookById(Integer id);
}
