package com.selfStudy.core.backstage.controllor.sources;

import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.backstage.service.SoftwareService;
import com.selfStudy.core.pojo.SsSoftware;
import com.selfStudy.core.pojo.vo.SsSoftwareVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：凌文
 * @ClassName SoftwareContronllor
 * @date ：Created in 2019/2/1 11:45
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Controller
@RequestMapping(value = "/BackSof")
public class SoftwareControllor {

    @Autowired
    public SoftwareService softwareService;

    /**
     * @Description 跳转软件管理页面
     * @author 凌文
     * @date 2019/2/2 9:29
     * @param[]
     * @return java.lang.String
     */
    @RequestMapping(value = "/toInsertSof")
    public String toInsertSof(){
        return "/sources/softwareAdd";
    }

    /**
     * @Description 添加软件
     * @author 凌文
     * @date 2019/2/2 9:32
     * @param[ssSoftware]
     * @return com.selfStudy.common.ServerRespose
     */
    @RequestMapping(value = "/insertSof",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose insertSof(@RequestParam(value = "softwareName") String softwareName,
                                   @RequestParam(value = "stageId") Integer stageId,
                                   @RequestParam(value = "dowsoftUrl") String dowsoftUrl,
                                   @RequestParam(value = "sofinstallUrl") String sofinstallUrl,
                                   @RequestParam(value = "remark") String remark){
        SsSoftware ssSoftware = new SsSoftware();
        ssSoftware.setSoftwareName(softwareName);
        ssSoftware.setStageId(stageId);
        ssSoftware.setDowsoftUrl(dowsoftUrl);
        ssSoftware.setSofinstallUrl(sofinstallUrl);
        ssSoftware.setRemark(remark);
        ServerRespose serverRespose = softwareService.insertSoftware(ssSoftware);
        return serverRespose;
    }

    /**
     * @Description 根据主键删除软件
     * @author 凌文
     * @date 2019/2/2 9:36
     * @param[id]
     * @return com.selfStudy.common.ServerRespose
     */
   @RequestMapping(value = "/delSof",method = RequestMethod.POST)
   @ResponseBody
    public ServerRespose delSofById(@RequestParam(value = "id") Integer id){
        ServerRespose serverRespose = softwareService.delSofById(id);
        return serverRespose;
    }

    @RequestMapping(value = "/delMoreSof",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public void delMoreSofById(@RequestParam(value = "ids")String ids){
        softwareService.delMoreSofById(ids);
    }

    /**
     * @Description 修改软件信息
     * @author 凌文
     * @date 2019/2/2 9:42
     * @param[ssSoftware]
     * @return com.selfStudy.common.ServerRespose
     */
    @RequestMapping(value = "/updateSof",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose updateSof(@RequestParam(value = "softwareName") String softwareName,
                                   @RequestParam(value = "id") Integer id,
                                   @RequestParam(value = "stageId") Integer stageId,
                                   @RequestParam(value = "dowsoftUrl") String dowsoftUrl,
                                   @RequestParam(value = "sofinstallUrl") String sofinstallUrl,
                                   @RequestParam(value = "remark") String remark) {
        SsSoftware ssSoftware = new SsSoftware();
        ssSoftware.setId(id);
        ssSoftware.setSoftwareName(softwareName);
        ssSoftware.setStageId(stageId);
        ssSoftware.setDowsoftUrl(dowsoftUrl);
        ssSoftware.setSofinstallUrl(sofinstallUrl);
        ssSoftware.setRemark(remark);
        ServerRespose serverRespose = softwareService.updateSoftware(ssSoftware);
        return serverRespose;
    }

    /**
     * @Description 获取id跳转软件修改页面
     * @author 凌文
     * @date 2019/2/5 20:47
     * @param[id]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = "/toUpdateSof",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView toUpdateSof(@RequestParam(value = "id") Integer id){
        ModelAndView view = new ModelAndView();
        List<SsSoftware> software = softwareService.selectSofById(id);
        List<SsSoftwareVo> softwares = softwareService.selectAllSoftware();
        view.addObject("software_name",softwares);
        view.addObject("dowsoft_url",softwares);
        view.addObject("sofinstall_url",softwares);
        view.addObject("envconfig_url",softwares);
        view.addObject("create_time",softwares);
        view.addObject("update_time",softwares);
        view.addObject("remark",softwares);
        view.addObject("software",software);
        view.setViewName("/sources/softwareUpdate");
        return view;
    }

    /**
     * @Description 进入软件管理页面
     * @author 凌文
     * @date 2019/2/7 17:29
     * @param[]
     * @return java.lang.String
     */
    @RequestMapping(value = "/sofList")
    public String toSofList(){
        return "/sources/softwareList";
    }

    /**
     * @Description 进入软件管理页面，无条件查询并分页
     * @author 凌文
     * @date 2019/2/7 17:29
     * @param[]
     * @return java.lang.String
     */
    @RequestMapping(value = "/selectAllSof",method = RequestMethod.GET)
    @ResponseBody
    public PageResult sofListMng(@RequestParam(value = "page",defaultValue = "1")int pageNum,
                                 @RequestParam(value = "limit",defaultValue = "10")int limit){
        PageResult pageResult = softwareService.selectAllSoftware(pageNum,limit);
        return pageResult;
    }
}
