package com.selfStudy.core.mapper;

import com.selfStudy.core.pojo.SsUser;
import com.selfStudy.core.pojo.SsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsUserMapper {
    int countByExample(SsUserExample example);

    int deleteByExample(SsUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsUser record);

    int insertSelective(SsUser record);

    List<SsUser> selectByExample(SsUserExample example);

    SsUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsUser record, @Param("example") SsUserExample example);

    int updateByExample(@Param("record") SsUser record, @Param("example") SsUserExample example);

    int updateByPrimaryKeySelective(SsUser record);

    int updateByPrimaryKey(SsUser record);

    List<SsUser> selectAllUser();

    SsUser userLogin(@Param("userName")String userName,@Param("pass") String pass);
}