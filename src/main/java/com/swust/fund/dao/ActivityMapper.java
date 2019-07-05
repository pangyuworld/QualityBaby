package com.swust.fund.dao;

import com.github.pagehelper.Page;
import com.swust.fund.entity.Activity;
import com.swust.fund.entity.ActivityGroup;

import java.util.List;

public interface ActivityMapper {
    int deleteByPrimaryKey(Integer activityId);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer activityId);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

    Page<Activity> selectAllActivity();

    ActivityGroup selectGroup(Integer groupId);

    Page<ActivityGroup> selectGroupByList(List<Integer> groupIdList);
}