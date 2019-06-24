package com.swust.fund.dao;

import com.swust.fund.entity.Studio;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudioMapper {
    int deleteByPrimaryKey(Integer studioId);

    int insert(Studio record);

    int insertSelective(Studio record);

    Studio selectByPrimaryKey(Integer studioId);

    int updateByPrimaryKeySelective(Studio record);

    int updateByPrimaryKey(Studio record);

    List<Studio> selectAll(@Param(value = "pageNum") Integer pageNum, @Param(value = "pageSize") Integer pageSize);

    int selectCount();

    List<Studio> selectByUserId(@Param(value = "userId") Integer userId, @Param(value = "pageNum") Integer pageNum, @Param(value = "pageSize") Integer pageSize);

    int selectCountByUserId(@Param(value = "userId") Integer userId);

    int signInStudio(@Param(value = "studioId") Integer studioId, @Param(value = "userId") Integer userId, @Param(value = "joinTime") Date joinTime);

    int signOutStudio(@Param(value = "studioId") Integer studioId, @Param(value = "userId") Integer userId);

    int selectUserAndStudio(@Param(value = "studioId") Integer studioId, @Param(value = "userId") Integer userId);
}