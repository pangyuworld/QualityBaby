package com.swust.fund.dao;

import com.swust.fund.entity.AspectDetail;

public interface AspectDetailMapper {
    int deleteByPrimaryKey(Integer detailId);

    int insert(AspectDetail record);

    int insertSelective(AspectDetail record);

    AspectDetail selectByPrimaryKey(Integer detailId);

    int updateByPrimaryKeySelective(AspectDetail record);

    int updateByPrimaryKey(AspectDetail record);
}