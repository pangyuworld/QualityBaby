package com.swust.fund.dao;

import com.github.pagehelper.Page;
import com.swust.fund.entity.Aspect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AspectMapper {
    int deleteByPrimaryKey(Integer aspectId);

    int insert(Aspect record);

    int insertSelective(Aspect record);

    Aspect selectByPrimaryKey(Integer aspectId);

    int updateByPrimaryKeySelective(Aspect record);

    int updateByPrimaryKey(Aspect record);

    List<Aspect> selectAllAspect(@Param("showAll") Boolean showAll);
}