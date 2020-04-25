package com.selfStudy.core.frontdesk.service.impl;

import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.frontdesk.service.UserService;
import com.selfStudy.core.mapper.SsUserMapper;
import com.selfStudy.core.pojo.SsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/4/9 7:36
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SsUserMapper userMapper;

    @Override
    public ServerRespose userSign(SsUser user) {
        int row = userMapper.insert(user);
        if(row > 0){
            return ServerRespose.CreateBySuccessMessage("1");
        }
        return ServerRespose.CreateByErrorMessage("0");
    }

    @Override
    public SsUser userLogin(String userName, String pass) {
        return userMapper.userLogin(userName,pass);
    }

//    @Override
//    public ServerRespose updateUser(SsUser user) {
//        return ServerRespose.CreateBySuccess(userMapper.updateByPrimaryKeySelective(user));
//    }
//
//    @Override
//    public ServerRespose updatePass(String userName, String oldPass,String password) {
//
//        return null;
//    }
}
