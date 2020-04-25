package com.selfStudy.core.backstage.controllor.sources;

import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.backstage.service.PanService;
import com.selfStudy.core.pojo.SsPan;
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
 * @ClassName PanContronllor
 * @date ：Created in 2019/2/11 7:39
 * @description：网盘资料contronllor
 * @modified By：
 * @version: $1.0
 * @Class:
 */
@Controller
@RequestMapping("/BackPan")
public class PanContronllor {

    @Autowired
    public PanService panService;

    @RequestMapping(value = "/toInsertPan")
    public String toInsertPan(){
        return "sources/panAdd";
    }

    /**
     * @Description 添加网盘资料
     * @author 凌文
     * @date 2019/2/16 18:28
     * @param[panTitle, stageId, panUrl, remark]
     * @return com.selfStudy.common.ServerRespose
     */
    @RequestMapping(value = "/insertPan",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose insertSof(@RequestParam(value = "panTitle") String panTitle,
                                   @RequestParam(value = "stageId") Integer stageId,
                                   @RequestParam(value = "panUrl") String panUrl,
                                   @RequestParam(value = "remark") String remark){
        SsPan pan = new SsPan();
        pan.setPanTitle(panTitle);
        pan.setStageId(stageId);
        pan.setPanUrl(panUrl);
        pan.setRemark(remark);
        ServerRespose serverRespose = panService.insertPan(pan);
        return serverRespose;
    }

    /**
     * @Description 根据id删除网盘资料
     * @author 凌文
     * @date 2019/2/17 9:02
     * @param[id]
     * @return com.selfStudy.common.ServerRespose
     */
    @RequestMapping(value = "/delPan",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose delPanById(@RequestParam(value = "id") Integer id){
        ServerRespose serverRespose = panService.delPan(id);
        return serverRespose;
    }

    /**
     * @Description 根据id批量删除网盘资料
     * @author 凌文
     * @date 2019/2/17 9:12
     * @param[ids]
     * @return void
     */
    @RequestMapping(value = "/delMorePan",method = RequestMethod.POST)
    @ResponseBody
    public void delMorePanById(String ids){
        panService.delMorePanById(ids);
    }

    /**
     * @Description 跳转网盘资料修改页面
     * @author 凌文
     * @date 2019/2/17 16:15
     * @param[id]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = "/toUpdatePan",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView toUpdatePan(@RequestParam(value = "id") Integer id){
        ModelAndView panView = new ModelAndView();
        List<SsPan> panList = panService.selectPanById(id);
        List<SsPan> panLists = panService.selectAllPan();
        panView.addObject("pan_title",panLists);
        panView.addObject("pan_url",panLists);
        panView.addObject("stage_id",panLists);
        panView.addObject("create_time",panLists);
        panView.addObject("update_time",panLists);
        panView.addObject("remark",panLists);
        panView.addObject("panList",panList);
        panView.setViewName("/sources/panUpdate");
        return panView;
    }

    /**
     * @Description 修改
     * @author 凌文
     * @date 2019/2/26 8:52
     * @param[panTitle, panUrl, stagId, remark]
     * @return com.selfStudy.common.ServerRespose
     */
    @RequestMapping(value = "/updatePan",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose updatePan(@RequestParam(value = "panTitle") String panTitle,
                                   @RequestParam(value = "id") Integer id,
                                   @RequestParam(value = "panUrl") String panUrl,
                                   @RequestParam(value = "stageId") Integer stagId,
                                   @RequestParam(value = "remark") String remark){
        SsPan ssPan = new SsPan();
        ssPan.setId(id);
        ssPan.setStageId(stagId);
        ssPan.setPanTitle(panTitle);
        ssPan.setPanUrl(panUrl);
        ssPan.setRemark(remark);
        ServerRespose serverRespose = panService.updatePan(ssPan);
        return serverRespose;
    }

    /**
     * @Description 跳转列表页
     * @author 凌文
     * @date 2019/2/26 8:55
     * @param[]
     * @return java.lang.String
     */
    @RequestMapping("/panList")
    public String panList(){
        return "/sources/panList";
    }

    /**
     * @Description 网盘资料列表
     * @author 凌文
     * @date 2019/2/26 8:53
     * @param[pageNum, pageSize]
     * @return com.selfStudy.common.PageResult<com.selfStudy.core.pojo.SsPan>
     */
    @RequestMapping(value = "/selectAllPan")
    @ResponseBody
    public PageResult<SsPan> selectAllPan(@RequestParam(value = "page") int pageNum,
                                          @RequestParam(value = "limit") int pageSize) {
        PageResult<SsPan> panPageResult = panService.selectAllPan(pageNum,pageSize);
        return  panPageResult;
    }
}
