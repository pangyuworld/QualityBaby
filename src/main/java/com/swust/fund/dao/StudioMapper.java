package com.swust.fund.dao;

import com.github.pagehelper.Page;
import com.swust.fund.entity.Studio;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudioMapper {
    int deleteByPrimaryKey(Integer studioId);

    int insert(Studio record);

    int insertSelective(Studio record);

    Studio selectByPrimaryKey(Integer studioId);

    int updateByPrimaryKeySelective(Studio record);

    int updateByPrimaryKey(Studio record);

    List<Studio> selectAll(@Param(value = "pageNum") Integer pageNum,@Param(value = "pageSize") Integer pageSize);

    int selectCount();
}