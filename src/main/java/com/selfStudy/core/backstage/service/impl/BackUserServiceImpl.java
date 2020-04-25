package com.selfStudy.core.backstage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.backstage.service.BackUserService;
import com.selfStudy.core.mapper.SsUserMapper;
import com.selfStudy.core.pojo.SsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/4/8 20:56
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Service
public class BackUserServiceImpl implements BackUserService {
    @Autowired
    private SsUserMapper userMapper;
    @Override
    public ServerRespose delUserkById(Integer id) {
        int row = userMapper.deleteByPrimaryKey(id);
        if(row>0){
            ServerRespose.CreateBySuccessMessage("删除成功！");
        }
        return ServerRespose.CreateByErrorMessage("删除失败！");
    }

    @Override
    public ServerRespose updateUserById(SsUser user) {
        int row = userMapper.updateByPrimaryKeySelective(user);
        if(row>0){
            ServerRespose.CreateBySuccessMessage("更新成功！");
        }
        return ServerRespose.CreateByErrorMessage("更新失败！");
    }

    @Override
    public SsUser selectUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult<SsUser> selectAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SsUser> userList = userMapper.selectAllUser();
        PageInfo pageInfo = new PageInfo(userList);
        return PageResult.ok(userList,pageInfo.getTotal());
    }
}
