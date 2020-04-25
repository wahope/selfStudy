package com.selfStudy.core.frontdesk.controllor;

import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.frontdesk.service.UserCollecteService;
import com.selfStudy.core.pojo.SsCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/4/9 20:54
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Controller
@RequestMapping("/Col")
public class UserColControllor {
    @Autowired
    private UserCollecteService userCollecteService;

    @RequestMapping("/insert")
    @ResponseBody
    public ServerRespose insertCol(@RequestParam(value = "userId") Integer userId,
                                   @RequestParam(value = "sourceIds") String sourceIds){
        ServerRespose serverRespose = userCollecteService.insertCollecte(userId,sourceIds);
        return serverRespose;
    }
    @RequestMapping("/selAllColByUserId")
    @ResponseBody
    public ServerRespose selectAllCollecte(@RequestParam(value = "pageNum")int pageNum,
                                           @RequestParam(value = "limit")int limit,
                                           @RequestParam(value = "userId")Integer userId) {
        ServerRespose serverRespose = userCollecteService.selectAllCollecte(pageNum, limit, userId);
        return serverRespose;
    }

    @RequestMapping("/delColById")
    @ResponseBody
    public ServerRespose delColById(@RequestParam(value = "id") Integer id){
        ServerRespose serverRespose = userCollecteService.delCollectById(id);
        return serverRespose;
    }
}

