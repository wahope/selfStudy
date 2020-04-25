package com.selfStudy.core.backstage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfStudy.common.PageResult;
import com.selfStudy.common.ServerRespose;
import com.selfStudy.core.backstage.service.AdminService;
import com.selfStudy.core.mapper.SsAdminMapper;
import com.selfStudy.core.pojo.SsAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/4/7 13:28
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private SsAdminMapper adminMapper;
    @Override
    public ServerRespose insertAdmin(SsAdmin ssAdmin) {
        int row = adminMapper.insert(ssAdmin);
        if(row != 0){
            return ServerRespose.CreateBySuccessMessage("管理员用户插入成功！");
        }
        return ServerRespose.CreateByErrorMessage("管理员用户插入失败！");
    }

    @Override
    public SsAdmin selectAdminByid(Integer id) {
        SsAdmin admin = adminMapper.selectByPrimaryKey(id);
        return admin;
    }

    @Override
    public ServerRespose updateAdminByid(SsAdmin ssAdmin) {
        int row = adminMapper.updateByPrimaryKey(ssAdmin);
        if(row != 0){
            return ServerRespose.CreateBySuccessMessage("管理员用户修改成功！");
        }
        return ServerRespose.CreateByErrorMessage("管理员用户修改失败！");
    }

    @Override
    public ServerRespose delAdminById(Integer id) {
        int row = adminMapper.deleteByPrimaryKey(id);
        if(row > 0){
            return ServerRespose.CreateBySuccessMessage("1");
        }
        return ServerRespose.CreateByErrorMessage("0");
    }

    @Override
    public PageResult<SsAdmin> selectAllAdmin(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SsAdmin> adminList = adminMapper.selectAllAdmin();
        PageInfo<SsAdmin> info = new PageInfo(adminList);
        return PageResult.ok(adminList,info.getTotal());
    }

    @Override
    public SsAdmin adminLogin(String account, String password) {
        SsAdmin admin = adminMapper.adminLogin(account,password);
        admin.setPassword("");
        return admin;
    }

    @Override
    public ServerRespose changePsw(String account, String oldPsw, String newPsw) {
        int row = adminMapper.changePsw(account, oldPsw, newPsw);
        if(row >0 ){
            return ServerRespose.CreateBySuccessMessage("1");
        }
        return ServerRespose.CreateByErrorMessage("0");
    }
}
