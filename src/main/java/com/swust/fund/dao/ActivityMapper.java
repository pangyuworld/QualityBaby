package com.swust.fund.dao;

import com.github.pagehelper.Page;
import com.swust.fund.entity.Activity;
import com.swust.fund.entity.ActivityGroup;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ActivityMapper {
    int deleteByPrimaryKey(Integer activityId);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer activityId);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

    Page<Activity> selectAllActivity(@Param("showAll") boolean showAll);

    ActivityGroup selectGroup(Integer groupId);

    Page<ActivityGroup> selectGroupByList(List<Integer> groupIdList);

    Page<Activity> selectAllActivityByGroup(@Param("groupId") Integer groupId, @Param("showAll") boolean showAll);

    Integer signInActivity(@Param("joinTime") Date joinTime, @Param("userId") Integer userId, @Param("activityId") Integer activityId);

    Page<Map> selectAllActivityByUser(@Param("groupId") Integer groupId, @Param("showAll") boolean showAll);

    Integer signOutActivity(@Param("userId") Integer userId, @Param("activityId") Integer activityId);

}