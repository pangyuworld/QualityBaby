package com.swust.fund.dao;

import com.swust.fund.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);

    User selectByOpenId(@Param(value = "openId") String openId);

    List<User> selectAll(@Param(value = "pageNum") Integer pageNum, @Param(value = "pageSize") Integer pageSize);

    int selectCount();
}