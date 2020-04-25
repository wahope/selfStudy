package com.selfStudy.core.backstage.controllor.sources;

import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.backstage.service.MechanismService;
import com.selfStudy.core.pojo.SsMechanism;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ：凌文
 * @ClassName MechanismControllor
 * @date ：Created in 2019/2/28 15:22
 * @description： 相关机构的信息
 * @modified By：
 * @version: $
 * @Class:
 */
@Controller
@RequestMapping("/BackMec")
public class MechanismControllor {
    @Autowired
    public MechanismService mechanismService;

    @RequestMapping("/toInsertMec")
    public String toInsertMec(){
        return "/sources/mechanismAdd";
    }

    @RequestMapping(value = "/insertMec",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose insertMec(@RequestParam(value = "mechanismName") String mechanismName,
                                   @RequestParam(value = "stageId") Integer stagId,
                                   @RequestParam(value = "mechanismUrl") String mechanismUrl,
                                   @RequestParam(value = "remark") String remark){
        SsMechanism mechanism = new SsMechanism();
        mechanism.setStageId(stagId);
        mechanism.setMechanismName(mechanismName);
        mechanism.setMechanismUrl(mechanismUrl);
        mechanism.setRemark(remark);
        return mechanismService.insertMechanism(mechanism);
    }

    @RequestMapping(value = "/delMec",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose delMecById(@RequestParam(value = "id") Integer id){
        return mechanismService.delWebById(id);
    }

    @RequestMapping(value = "/delMoreMec",method = RequestMethod.POST)
    @ResponseBody
    public void delMoreMecById(@RequestParam(value = "ids") String ids){
        mechanismService.delMoreWebById(ids);
    }

    @RequestMapping("/toUpdateMec")
    @ResponseBody
    public ModelAndView toUpdateMec(@RequestParam(value = "id") Integer id){
        ModelAndView view = new ModelAndView();
        SsMechanism mechanism = mechanismService.selectMecById(id);
        view.addObject("id",mechanism.getId());
        view.addObject("mechanismName",mechanism.getMechanismName());
        view.addObject("mechanismUrl",mechanism.getMechanismUrl());
        view.addObject("stageId",mechanism.getStageId());
        view.addObject("createTime",mechanism.getCreateTime());
        view.addObject("updateTime",mechanism.getUpdateTime());
        view.addObject("remark",mechanism.getRemark());
        view.setViewName("sources/mechanismUpdate");
        return view;
    }

    @RequestMapping(value = "/updateMec",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose updateMec(@RequestParam(value = "id") Integer id,
                                   @RequestParam(value = "mechanismName") String mechanismName,
                                   @RequestParam(value = "stageId") Integer stagId,
                                   @RequestParam(value = "mechanismUrl") String mechanismUrl,
                                   @RequestParam(value = "remark") String remark){
        SsMechanism mechanism = new SsMechanism();
        mechanism.setId(id);
        mechanism.setStageId(stagId);
        mechanism.setMechanismName(mechanismName);
        mechanism.setMechanismUrl(mechanismUrl);
        mechanism.setRemark(remark);
        return mechanismService.updateWebById(mechanism);
    }

    @RequestMapping(value = "/mecList")
    public String mecList(){
        return "/sources/mechanismList";
    }

    @RequestMapping(value = "/selectAllMec")
    @ResponseBody
    public PageResult mecListMng(@RequestParam(value = "page",defaultValue = "1")int pageNum,
                                 @RequestParam(value = "limit",defaultValue = "10")int limit){
        return mechanismService.selectAllMechanism(pageNum,limit);
    }

}
