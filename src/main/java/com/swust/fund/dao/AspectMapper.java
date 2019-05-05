package com.swust.fund.dao;

import com.swust.fund.entity.Aspect;

public interface AspectMapper {
    int deleteByPrimaryKey(Integer aspectId);

    int insert(Aspect record);

    int insertSelective(Aspect record);

    Aspect selectByPrimaryKey(Integer aspectId);

    int updateByPrimaryKeySelective(Aspect record);

    int updateByPrimaryKey(Aspect record);
}