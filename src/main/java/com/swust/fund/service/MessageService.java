package com.swust.fund.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.swust.fund.dao.MessageMapper;
import com.swust.fund.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author pang
 * @version V1.0
 * @ClassName: MessageService
 * @Package com.swust.fund.service
 * @description: 留言事务层
 * @date 2019/7/8 16:45
 */
@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    /**
     * 获得所有留言
     *
     * @param pageNum  页码
     * @param pageSize 大小
     * @param showAll  是否全部显示
     * @return com.github.pagehelper.PageInfo<com.swust.fund.entity.Message>
     * @author pang
     * @date 2019/7/8
     */
    public PageInfo<Message> getMessage(int pageNum, int pageSize, boolean showAll) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Message> messagePage = messageMapper.selectAllMessage();
        return new PageInfo<>(messagePage);
    }

    /**
     * 根据Id获得留言
     *
     * @param messageId 留言ID
     * @return com.swust.fund.entity.Message
     * @author pang
     * @date 2019/7/8
     */
    public Message getMessage(int messageId) {
        return messageMapper.selectByPrimaryKey(messageId);
    }

    /**
     * 添加新的留言(时间自动生成)
     *
     * @param message 新的留言内容
     * @return java.lang.Integer
     * @author pang
     * @date 2019/7/8
     */
    public Integer addMessage(Message message) {
        message.setMessageTime(new Date());
        return messageMapper.insert(message);
    }

    /**
     * 更新留言内容
     *
     * @param message 更新过后的留言内容
     * @return java.lang.Integer
     * @author pang
     * @date 2019/7/8
     */
    public Integer editMessage(Message message) {
        return messageMapper.updateByPrimaryKeySelective(message);
    }

    /**
     * 删除留言
     *
     * @param messageId 要删除留言ID
     * @return boolean 删除成功返回true，否则返回false
     * @author pang
     * @date 2019/7/8
     */
    public boolean deleteMessage(Integer messageId) {
        if (messageMapper.deleteByPrimaryKey(messageId) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
