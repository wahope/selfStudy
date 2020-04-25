package com.selfStudy.core.mapper;

import com.selfStudy.core.pojo.SsAdmin;
import com.selfStudy.core.pojo.SsAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsAdminMapper {
    int countByExample(SsAdminExample example);

    int deleteByExample(SsAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsAdmin record);

    int insertSelective(SsAdmin record);

    List<SsAdmin> selectByExample(SsAdminExample example);

    SsAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsAdmin record, @Param("example") SsAdminExample example);

    int updateByExample(@Param("record") SsAdmin record, @Param("example") SsAdminExample example);

    int updateByPrimaryKeySelective(SsAdmin record);

    int updateByPrimaryKey(SsAdmin record);

    List<SsAdmin> selectAllAdmin();

    SsAdmin adminLogin(@Param(value = "account") String account,
                       @Param(value = "password") String password);

    int changePsw(@Param(value = "account")String account,
                  @Param(value = "oldPsw")String oldPsw,
                  @Param(value = "newPsw")String newPsw);
}