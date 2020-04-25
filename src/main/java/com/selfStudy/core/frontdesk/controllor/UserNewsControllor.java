package com.selfStudy.core.frontdesk.controllor;

import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.frontdesk.service.UserNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：凌文
 * @ClassName NewsControllor
 * @date ：Created in 2019/4/1 17:21
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Controller
@RequestMapping("/News")
public class UserNewsControllor {
    @Autowired
    private UserNewsService userNewsService;

    @RequestMapping(value = "/selectNewsById",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose selectNewsById(@RequestParam(value = "id") Integer id){
        return userNewsService.selectNewsById(id);
    }

    @RequestMapping(value = "/selectNewsInfo")
    @ResponseBody
    public ServerRespose selectAllNews(@RequestParam(value = "pageNum")int pageNum,
                                       @RequestParam(value = "limit")int limit,
                                       @RequestParam(value = "sid")Integer sid){
        return ServerRespose.CreateBySuccess(userNewsService.selectAllNewsUser(pageNum, limit,sid));
    }

}
