package com.selfStudy.core.backstage.service;

import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.pojo.SsBook;
import com.selfStudy.core.pojo.SsUser;

public interface BackUserService {

    ServerRespose delUserkById(Integer id);

    ServerRespose updateUserById(SsUser user);

    SsUser selectUserById(Integer id);

    PageResult<SsUser> selectAllUser(int pageNum, int pageSize);
}
