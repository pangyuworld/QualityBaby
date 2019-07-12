package com.swust.fund.dao;

import com.github.pagehelper.Page;
import com.swust.fund.entity.ActivityGroup;
import org.apache.ibatis.annotations.Param;

public interface ActivityGroupMapper {
    int deleteByPrimaryKey(Integer groupId);

    int insert(ActivityGroup record);

    int insertSelective(ActivityGroup record);

    ActivityGroup selectByPrimaryKey(Integer groupId);

    int updateByPrimaryKeySelective(ActivityGroup record);

    int updateByPrimaryKey(ActivityGroup record);

    Page<ActivityGroup> selectAllGroup(@Param("showAll") boolean showAll);
}