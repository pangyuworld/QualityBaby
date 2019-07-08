package com.swust.fund.dao;

import com.github.pagehelper.Page;
import com.swust.fund.entity.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer tagId);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    Page<Tag> selectAllTag(@Param("showAll") boolean showAll);

    List<Tag> selectAllTagByUser(@Param("userId") int userId, @Param("showAll") boolean showAll);

    List<Tag> selectAllTagByActivity(@Param("activityId") int activityId, @Param("showAll") boolean showAll);
}