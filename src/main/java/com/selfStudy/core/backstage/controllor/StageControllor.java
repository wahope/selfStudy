package com.selfStudy.core.backstage.controllor;

import com.selfStudy.core.backstage.service.StageService;
import com.selfStudy.core.pojo.SsStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/2/12 16:27
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Controller
@RequestMapping("/BackStage")
public class StageControllor {

    @Autowired
    public StageService stageService;

    @RequestMapping(value = "/selStageBySpe")
    @ResponseBody
    public List<SsStage> selectStageBySpeId(@RequestParam(value = "specialtyId") Integer specialtyId){
        List<SsStage> stageList =  stageService.selectStageBySpeId(specialtyId);
        return stageList;
    }
}
