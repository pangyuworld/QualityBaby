package com.swust.fund.dao;

import com.swust.fund.entity.Option;

public interface OptionMapper {
    int deleteByPrimaryKey(Integer optionId);

    int insert(Option record);

    int insertSelective(Option record);

    Option selectByPrimaryKey(Integer optionId);

    int updateByPrimaryKeySelective(Option record);

    int updateByPrimaryKey(Option record);
}