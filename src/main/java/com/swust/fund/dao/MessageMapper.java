package com.swust.fund.dao;

import com.github.pagehelper.Page;
import com.swust.fund.entity.Message;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer messageId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer messageId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    Page<Message> selectAllMessage();

    int likeMessage(Integer messageId);

    int unlikeMessage(Integer messageId);
}