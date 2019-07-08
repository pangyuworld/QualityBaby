package com.swust.fund.dao;

import com.github.pagehelper.Page;
import com.swust.fund.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);

    User selectByOpenId(@Param(value = "openId") String openId);

    Page<User> selectAll();

    int selectCount();

    Page<Map> selectByActivityId(@Param(value = "activityId") Integer activityId);

    int selectCountByActivityId(@Param(value = "activityId") Integer activityId);

}