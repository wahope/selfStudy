package com.selfStudy.core.backstage.controllor;

import com.selfStudy.common.JSONUtils;
import com.selfStudy.core.backstage.service.SpecialtyService;
import com.selfStudy.core.pojo.SsSpecialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/2/12 9:57
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Controller
@RequestMapping("/BackSpe")
public class SpecialtyControllor {
    @Autowired
    public SpecialtyService specialtyService;

    @RequestMapping(value = "/selectAllSpe")
    @ResponseBody
    public List<SsSpecialty> selectAllSpe(){
        List<SsSpecialty> specialty = specialtyService.selectAllSpe();
        //JSONUtils.toJSONArray(specialty);
        return specialty;
    }
}
