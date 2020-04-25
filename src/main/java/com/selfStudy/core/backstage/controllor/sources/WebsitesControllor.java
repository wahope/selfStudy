package com.selfStudy.core.backstage.controllor.sources;

import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.backstage.service.WebsitesService;
import com.selfStudy.core.pojo.SsWebsites;
import com.selfStudy.core.pojo.vo.SsWebsitesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/2/27 10:02
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Controller
@RequestMapping("/BackWeb")
public class WebsitesControllor {
    @Autowired
    public WebsitesService websitesService;

    @RequestMapping("/toInsertWeb")
    public String toInsertWeb(){
        return "/sources/websitesAdd";
    }

    @RequestMapping(value = "/insertWeb",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose insertWeb(@RequestParam(value = "websitesName") String websitesName,
                                   @RequestParam(value = "websitesUrl") String websitesUrl,
                                   @RequestParam(value = "stageId") Integer stageId,
                                   @RequestParam(value = "remark") String remark){
        SsWebsites websites = new SsWebsites();
        websites.setWebsitesName(websitesName);
        websites.setWebsitesUrl(websitesUrl);
        websites.setStageId(stageId);
        websites.setRemark(remark);
        return websitesService.insertWebsites(websites);
    }

    @RequestMapping(value = "/delWeb",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose delWebByid(Integer id){
        return websitesService.delWebById(id);
    }

    @RequestMapping(value = "/delMoreWeb",method = RequestMethod.POST)
    @ResponseBody
    public void delMoreWebById(@RequestParam(value = "ids") String ids){
        websitesService.delMoreWebById(ids);
    }

    @RequestMapping("/toUpdateWeb")
    public ModelAndView toUpdateSof(@RequestParam(value = "id") Integer id){
        ModelAndView view = new ModelAndView();
       SsWebsites websites = websitesService.selectWebById(id);
        view.addObject("id",websites.getId());
        view.addObject("websitesName",websites.getWebsitesName());
        view.addObject("stageId",websites.getStageId());
        view.addObject("websitesUrl",websites.getWebsitesUrl());
        view.addObject("createTime",websites.getCreateTime());
        view.addObject("updateTime",websites.getUpdateTime());
        view.addObject("remark",websites.getRemark());
        view.setViewName("sources/websitesUpdate");
        return view;
    }

    @RequestMapping(value = "/updateWeb",method = RequestMethod.POST)
    @ResponseBody//不跳转页面使用
    public ServerRespose updateWeb(@RequestParam(value = "id") Integer id,
                                   @RequestParam(value = "websitesName") String websitesName,
                                   @RequestParam(value = "stageId") Integer stagId,
                                   @RequestParam(value = "websitesUrl") String websitesUrl,
                                   @RequestParam(value = "remark") String remark){
        SsWebsites websites = new SsWebsites();
        websites.setId(id);
        websites.setWebsitesName(websitesName);
        websites.setStageId(stagId);
        websites.setWebsitesUrl(websitesUrl);
        websites.setRemark(remark);
        return websitesService.updateWebById(websites);
    }

    @RequestMapping("/webList")
    public String webList(){
        return "sources/websitesList";
    }

    @RequestMapping("/selectAllWeb")
    @ResponseBody
    public PageResult webListMng(@RequestParam(value = "page",defaultValue = "1")int pageNum,
                                 @RequestParam(value = "limit",defaultValue = "10")int limit){
        return websitesService.selectAllWebsites(pageNum,limit);
    }

}
