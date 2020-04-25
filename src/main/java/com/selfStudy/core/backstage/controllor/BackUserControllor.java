package com.selfStudy.core.backstage.controllor;

import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.backstage.service.BackUserService;
import com.selfStudy.core.pojo.SsAdmin;
import com.selfStudy.core.pojo.SsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/4/8 21:08
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Controller
@RequestMapping("/BackUser")
public class BackUserControllor {
    @Autowired
    private BackUserService backUserService;

    @RequestMapping(value = "/delUser",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose delUserById(@RequestParam(value = "id") Integer id){
        ServerRespose serverRespose = backUserService.delUserkById(id);
        return serverRespose;
    }

    @RequestMapping(value = "/toUpdateUser",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView toUpdateUser(@RequestParam(value = "id") Integer id){
        ModelAndView view = new ModelAndView();
        SsUser user = backUserService.selectUserById(id);
        view.addObject("id",user.getId());
        view.addObject("userName",user.getUserName());
        view.addObject("password",user.getPassword());
        view.addObject("mobile",user.getMobile());
        view.addObject("address",user.getAddress());
        view.addObject("createTime",user.getCreateTime());
        view.addObject("remark",user.getRemark());
        view.setViewName("/user/userUpdate");
        return view;
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose updateUser(SsUser user){
        ServerRespose serverRespose = backUserService.updateUserById(user);
        return serverRespose;
    }

    @RequestMapping(value = "/userList")
    public String bookList(){
        return "/user/userList";
    }

    @RequestMapping(value = "/selectAllUser")
    @ResponseBody
    public PageResult selectAllUser(@RequestParam(value = "page",defaultValue = "1")int pageNum,
                                  @RequestParam(value = "limit",defaultValue = "10")int limit){
        return backUserService.selectAllUser(pageNum,limit);
    }
}
