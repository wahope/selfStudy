package com.selfStudy.core.frontdesk.controllor;

import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.frontdesk.service.UserBookService;
import com.selfStudy.core.pojo.SsBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/4/5 16:35
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Controller
@RequestMapping("/Book")
public class UserBookControllor {
    @Autowired
    private UserBookService userBookService;

    @RequestMapping(value = "/selectBookByStageId",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose<SsBook> selectBookById(@RequestParam(value = "pageNum")int pageNum,
                                           @RequestParam(value = "limit")int limit,
                                           @RequestParam(value = "stageId")Integer stageId){
        ServerRespose serverRespose = userBookService.selectAllBookByStaId(pageNum, limit, stageId);
        return serverRespose;
    }

    @RequestMapping(value = "/selectSource",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose selectSourceByStaId(@RequestParam(value = "stageId")Integer stageId){
        ServerRespose serverRespose = userBookService.selectSourceByStaId(stageId);
        return serverRespose;
    }

    @RequestMapping(value = "/selectBookById",method = RequestMethod.GET)
    @ResponseBody
    public ServerRespose selectBookById(@RequestParam(value = "id")Integer id){
        ServerRespose serverRespose = userBookService.selectBookById(id);
        return serverRespose;
    }
}
