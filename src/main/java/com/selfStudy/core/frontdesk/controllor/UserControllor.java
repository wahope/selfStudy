package com.selfStudy.core.frontdesk.controllor;

import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.frontdesk.service.UserService;
import com.selfStudy.core.pojo.SsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/4/9 8:47
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Controller
@RequestMapping("/User")
public class UserControllor {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose login(String userName, String pass, HttpSession session){
        SsUser user = userService.userLogin(userName,pass);
        if(user != null){
            user.setPassword("");
            session.setAttribute("USER",user);
            return ServerRespose.CreateBySuccess(user);
        }
        return  ServerRespose.CreateByErrorMessage("用户名或密码错误!");
    }

    @RequestMapping(value = "/sign",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose userSign(SsUser user){
//        SsUser user = new SsUser();
//        user.setUserName(userName);
//        user.setPassword(password);
//        user.setMobile(mobile);
//        user.setAddress(address);
        return userService.userSign(user);
    }
}
