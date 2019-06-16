package com.swust.fund.dao;

import com.swust.fund.entity.Activity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ActivityMapper {
    int deleteByPrimaryKey(Integer activityId);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer activityId);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

    List<Activity> selectAll(@Param(value = "pageNum") Integer pageNum, @Param(value = "pageSize") Integer pageSize);

    List<Activity> selectAllByStudio(@Param(value = "studioId") Integer studioId, @Param(value = "pageNum") Integer pageNum, @Param(value = "pageSize") Integer pageSize);

    int selectCount();

    int selectCountByStudio(@Param(value = "studioId") Integer studioId);

    List<Activity> selectByUserId(@Param(value = "userId") Integer userId, @Param(value = "pageNum") Integer pageNum, @Param(value = "pageSize") Integer pageSize);

    int selectCountByUserId(@Param(value = "userId") Integer userId);

    int signInActivity(@Param(value = "activityId") Integer activityId,
                       @Param(value = "userId") Integer userId,
                       @Param(value = "joinTime") Date joinTime);

    int signOutActivity(@Param(value = "activityId") Integer activityId,
                        @Param(value = "userId") Integer userId);

}