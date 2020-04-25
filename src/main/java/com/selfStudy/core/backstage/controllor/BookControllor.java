package com.selfStudy.core.backstage.controllor;

import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.backstage.service.BookService;
import com.selfStudy.core.pojo.SsBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ：凌文
 * @ClassName BookControllor
 * @date ：Created in 2019/3/4 17:02
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Controller
@RequestMapping("BackBook")
public class BookControllor {
    @Autowired
    public BookService bookService;

    @RequestMapping("/toInsertBook")
    public String toInsertBook(){
        return "/book/bookAdd";
    }

    @RequestMapping(value = "/insertBook",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose insertBook(SsBook book){
        return bookService.insertBook(book);
    }

    @RequestMapping(value = "/delBook",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose delBookById(@RequestParam(value = "id") Integer id){
        return bookService.delBookById(id);
    }

    @RequestMapping(value = "/delMoreBook",method = RequestMethod.POST)
    @ResponseBody
    public void delMoreBookById(@RequestParam(value = "ids") String ids){
        bookService.delMoreBookById(ids);
    }

    @RequestMapping("/toUpdateBook")
    @ResponseBody
    public ModelAndView toUpdateBook(@RequestParam(value = "id") Integer id){
        ModelAndView view = new ModelAndView();
        SsBook book = bookService.selectBookById(id);
        view.addObject("id",book.getId());
        view.addObject("bookName",book.getBookName());
        view.addObject("author",book.getAuthor());
        view.addObject("press",book.getPress());
        view.addObject("bookUrl",book.getBookUrl());
        view.addObject("bookIntro",book.getBookIntro());
        view.addObject("createTime",book.getCreateTime());
        view.addObject("updateTime",book.getUpdateTime());
        view.addObject("remark",book.getRemark());
        view.setViewName("/book/bookUpdate");
        return view;
    }

//    @RequestMapping(value = "/updateBook",method = RequestMethod.POST)
//    @ResponseBody
//    public ServerRespose updateBook(@RequestParam(value = "id") Integer id,
//                                    @RequestParam(value = "bookName") String bookName,
//                                    @RequestParam(value = "author") String author,
//                                    @RequestParam(value = "press") String press,
//                                    @RequestParam(value = "bookUrl") String bookUrl,
//                                    @RequestParam(value = "bookIntro") String bookIntro,
//                                    @RequestParam(value = "stageId") Integer stageId,
//                                    @RequestParam(value = "remark") String remark){
//        SsBook book = new SsBook();
//        book.setId(id);
//        book.setBookName(bookName);
//        book.setAuthor(author);
//        book.setPress(press);
//        book.setBookUrl(bookUrl);
//        book.setBookIntro(bookIntro);
//        book.setStageId(stageId);
//        book.setRemark(remark);
//        return bookService.updateBookById(book);
//    }

    @RequestMapping(value = "/updateBook",method = RequestMethod.POST)
    @ResponseBody
    public ServerRespose updateBook(SsBook book){
        return bookService.updateBookById(book);
    }

    @RequestMapping(value = "/bookList")
    public String bookList(){
        return "/book/bookList";
    }

    @RequestMapping(value = "/selectAllBook")
    @ResponseBody
    public PageResult bookListMng(@RequestParam(value = "page",defaultValue = "1")int pageNum,
                                  @RequestParam(value = "limit",defaultValue = "10")int limit){
        return bookService.selectAllBook(pageNum,limit);
    }
}
