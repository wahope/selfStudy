package com.selfStudy.core.backstage.service;

import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.pojo.SsAdmin;

public interface AdminService {
    ServerRespose insertAdmin(SsAdmin ssAdmin);
    SsAdmin selectAdminByid(Integer id);
    ServerRespose updateAdminByid(SsAdmin ssAdmin);
    ServerRespose delAdminById(Integer id);
    PageResult selectAllAdmin(int pageNum, int pageSize);
    SsAdmin adminLogin(String account,String password);
    ServerRespose changePsw(String account,String oldPsw,String newPsw);
}
