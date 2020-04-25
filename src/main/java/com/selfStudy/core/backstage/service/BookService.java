package com.selfStudy.core.backstage.service;

import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.pojo.SsBook;
import com.selfStudy.core.pojo.SsBookWithBLOBs;
import com.selfStudy.core.pojo.SsNews;
import com.selfStudy.core.pojo.vo.SsBookVo;
import com.selfStudy.core.pojo.vo.SsNewsVo;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/3/3 10:57
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
public interface BookService {
    ServerRespose insertBook(SsBook book);

    ServerRespose delBookById(Integer id);

    void delMoreBookById(String ids);

    ServerRespose updateBookById(SsBook book);

    SsBook selectBookById(Integer id);

    PageResult<SsBookVo> selectAllBook(int pageNum, int pageSize);
}
