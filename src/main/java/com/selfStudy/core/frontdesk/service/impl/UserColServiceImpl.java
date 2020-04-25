package com.selfStudy.core.frontdesk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.frontdesk.service.UserCollecteService;
import com.selfStudy.core.mapper.SsCollectionMapper;
import com.selfStudy.core.pojo.SsCollection;
import com.selfStudy.core.pojo.vo.SsCollectionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/4/9 11:41
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Service
public class UserColServiceImpl implements UserCollecteService {
    @Autowired
    private SsCollectionMapper collectionMapper;
    @Override
    public ServerRespose insertCollecte(Integer userId,String sourceIds) {
        String[] ids =sourceIds.split(",");
        int row=0;
        for (String id:ids) {
            Integer sourceId = Integer.parseInt(id);
            SsCollection collection = new SsCollection();
            collection.setUserId(userId);
            collection.setSourceId(sourceId);
            row = collectionMapper.insert(collection);
        }
        if(row == 0){
            return ServerRespose.CreateByErrorMessage("书籍收藏失败！");
        }
        return ServerRespose.CreateBySuccessMessage("书籍收藏成功！");
    }

    @Override
    public ServerRespose delCollectById(Integer id) {
        int row = collectionMapper.deleteByPrimaryKey(id);
        if(row == 0){
            return ServerRespose.CreateByErrorMessage("收藏删除失败！");
        }
        return ServerRespose.CreateBySuccessMessage("收藏删除成功！");
    }

    @Override
    public ServerRespose selectAllCollecte(int pageNum, int limit,Integer userId) {
        PageHelper.startPage(pageNum,limit);
        List<SsCollectionVo> list = collectionMapper.selectAllCollecte(userId);
        if(list.size()==0){
            return ServerRespose.CreateByErrorMessage("很抱歉，没有数据！");
        }
        PageInfo pageInfo = new PageInfo<SsCollectionVo>(list);
        return ServerRespose.CreateBySuccess(pageInfo);
    }
}
