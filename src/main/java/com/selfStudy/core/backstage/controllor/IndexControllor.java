package com.selfStudy.core.backstage.controllor;

import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.backstage.service.AdminService;
import com.selfStudy.core.pojo.SsAdmin;
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
 * @date ：Created in 2019/2/5 15:51
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Controller
public class IndexControllor {
    @Autowired
    private AdminService adminService;
    @RequestMapping(value = "/index")
    public String toIndex(){
        return "/index";
    }

    @RequestMapping(value = "/logins")
    public String toLogin(){
        return "/login/login";
    }

    @RequestMapping(value = "/toLogin",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose login(@RequestParam("account")String account,
                               @RequestParam("password")String password,
                               HttpSession session){
        SsAdmin admin = adminService.adminLogin(account,password);
        session.setAttribute("ADMIN",admin);
        return ServerRespose.CreateBySuccess(admin);
    }

    @RequestMapping(value = "/loginOut",method = RequestMethod.POST)
    @ResponseBody
    public void login(HttpSession session){
        session.removeAttribute("ADMIN");
    }

    @RequestMapping(value = "/toChangePwd")
    public String toChangePwd(){
        return "/login/changePwd";
    }

    @RequestMapping(value = "/updatePassword")
    @ResponseBody
    public ServerRespose changePwd(@RequestParam(value = "account")String account,
                                   @RequestParam(value = "oldPsw")String oldPsw,
                                   @RequestParam(value = "newPsw")String newPsw){
        return adminService.changePsw(account, oldPsw, newPsw);
    }

}
