package com.selfStudy.core.backstage.controllor;

import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.backstage.service.NewsSerrvice;
import com.selfStudy.core.pojo.SsNews;
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
 * @date ：Created in 2019/3/1 21:23
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Controller
@RequestMapping("/BackNews")
public class NewsControllor {
    @Autowired
    public NewsSerrvice newsSerrvice;

    @RequestMapping("/toInsertNews")
    public String toInsertNews(){
        return "/news/newsAdd";
    }

    @RequestMapping(value = "/insertNews",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose insertNews(@RequestParam(value = "title") String title,
                                   @RequestParam(value = "content") String content,
                                   @RequestParam(value = "specialtyId") Integer specialtyId,
                                   @RequestParam(value = "remark") String remark){
        SsNews news = new SsNews();
        news.setTitle(title);
        news.setContent(content);
        news.setSpecialtyId(specialtyId);
        news.setRemark(remark);
        return newsSerrvice.insertNews(news);
    }

    @RequestMapping(value = "/delNews",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose delNewsById(@RequestParam(value = "id") Integer id){
        return newsSerrvice.delNewsById(id);
    }

    @RequestMapping(value = "/delMoreNews",method = RequestMethod.POST)
    @ResponseBody
    public void delMoreNewsById(@RequestParam(value = "ids") String ids){
        newsSerrvice.delMoreNewsById(ids);
    }

    @RequestMapping("/toUpdateNews")
    @ResponseBody
    public ModelAndView toUpdateNews(@RequestParam(value = "id") Integer id){
        ModelAndView view = new ModelAndView();
        SsNews news = newsSerrvice.selectNewsById(id);
        view.addObject("id",news.getId());
        view.addObject("title",news.getTitle());
        view.addObject("content",news.getContent());
        view.addObject("specialtyId",news.getSpecialtyId());
        view.addObject("createTime",news.getCreateTime());
        view.addObject("updateTime",news.getUpdateTime());
        view.addObject("remark",news.getRemark());
        view.setViewName("/news/newsUpdate");
        return view;
    }

    @RequestMapping(value = "/updateNews",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose updateNews(@RequestParam(value = "title") String title,
                                    @RequestParam(value = "id") Integer id,
                                    @RequestParam(value = "content") String content,
                                    @RequestParam(value = "specialtyId") Integer specialtyId,
                                    @RequestParam(value = "remark") String remark){
        SsNews news = new SsNews();
        news.setId(id);
        news.setTitle(title);
        news.setContent(content);
        news.setSpecialtyId(specialtyId);
        news.setRemark(remark);
        return newsSerrvice.updateNewsById(news);
    }

    @RequestMapping(value = "/newsList")
    public String newsList(){
        return "/news/newsList";
    }

    @RequestMapping(value = "/selectAllNews")
    @ResponseBody
    public PageResult newsListMng(@RequestParam(value = "page",defaultValue = "1")int pageNum,
                                 @RequestParam(value = "limit",defaultValue = "10")int limit){
        return newsSerrvice.selectAllNews(pageNum,limit);
    }
}
