package com.selfStudy.core.backstage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.backstage.service.BookService;
import com.selfStudy.core.mapper.SsBookMapper;
import com.selfStudy.core.pojo.SsBook;
import com.selfStudy.core.pojo.vo.SsBookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：凌文
 * @ClassName BookServiceImpl
 * @date ：Created in 2019/3/3 10:59
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    public SsBookMapper bookMapper;

    @Override
    public ServerRespose insertBook(SsBook book) {
        int count = bookMapper.insert(book);
        if(count>0){
           return ServerRespose.CreateBySuccessMessage("书籍添加成功！");
        }
        return ServerRespose.CreateByErrorMessage("书籍添加失败！");
    }

    @Override
    public ServerRespose delBookById(Integer id) {
        int count = bookMapper.deleteByPrimaryKey(id);
        if(count>0){
           return ServerRespose.CreateBySuccessMessage("新闻动态删除成功！");
        }
        return ServerRespose.CreateByErrorMessage("新闻动态删除失败！");
    }

    @Override
    public void delMoreBookById(String ids) {
        String[] id = ids.split(",");
        for (String item:id) {
            bookMapper.deleteByPrimaryKey(Integer.parseInt(item));
        }
    }

    @Override
    public ServerRespose updateBookById(SsBook book) {
        int count = bookMapper.updateByPrimaryKeySelective(book);
        if(count>0){
            return ServerRespose.CreateBySuccessMessage("更新书籍成功！");
        }
        return ServerRespose.CreateByErrorMessage("更新失败！");
    }

    @Override
    public SsBook selectBookById(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult<SsBookVo> selectAllBook(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SsBookVo> bookVoList = bookMapper.selectAllBook();
        PageInfo pageInfo = new PageInfo(bookVoList);
        return PageResult.ok(bookVoList,pageInfo.getTotal());
    }
}
