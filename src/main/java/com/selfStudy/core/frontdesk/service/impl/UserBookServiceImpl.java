package com.selfStudy.core.frontdesk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.SocketMetadata;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.frontdesk.service.UserBookService;
import com.selfStudy.core.mapper.SsBookMapper;
import com.selfStudy.core.pojo.SsBook;
import com.selfStudy.core.pojo.vo.UserSourceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/4/5 16:30
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Service
public class UserBookServiceImpl implements UserBookService {
    @Autowired
    private SsBookMapper bookMapper;


    @Override
    public ServerRespose selectAllBookByStaId(int pageNum, int limit, Integer stageId) {
        PageHelper.startPage(pageNum,limit);
        List<SsBook> list = bookMapper.selectAllBookByStaId(stageId);
        if(list.size()==0){
            return ServerRespose.CreateByErrorMessage("很抱歉，没有数据！");
        }
        PageInfo pageInfo = new PageInfo<SsBook>(list);
        return ServerRespose.CreateBySuccess(pageInfo);
    }

    @Override
    public ServerRespose selectSourceByStaId(Integer stageId) {
        List<UserSourceVo> list = bookMapper.selectSourceByStaId(stageId);
        return ServerRespose.CreateBySuccess(list);
    }

    @Override
    public ServerRespose selectBookById(Integer id) {
        SsBook book = bookMapper.selectBookById(id);
        return ServerRespose.CreateBySuccess(book);
    }
}
