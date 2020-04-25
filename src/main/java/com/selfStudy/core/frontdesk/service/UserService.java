package com.selfStudy.core.frontdesk.service;

import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.pojo.SsUser;

import javax.servlet.http.HttpSession;

public interface UserService {
    ServerRespose userSign(SsUser user);
    SsUser userLogin(String userName,String pass);
//    ServerRespose updateUser(SsUser user);
//    ServerRespose updatePass(String userName,String oldPass,String password);
}
