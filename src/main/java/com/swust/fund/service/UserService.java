package com.swust.fund.service;

import com.swust.fund.common.Page;
import com.swust.fund.common.restful.UnicomResponseEnums;
import com.swust.fund.common.restful.UnicomRuntimeException;
import com.swust.fund.dao.UserMapper;
import com.swust.fund.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: UserService
 * @Package com.swust.fund.service
 * @description: 用户事务处理层
 * @date 2019/5/11 9:34
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据openID查询用户
     *
     * @param openId 用户微信唯一标识
     * @return com.swust.fund.entity.User
     * @author pang
     * @date 2019/5/11
     */
    public User getUserByOpenId(String openId) {
        return userMapper.selectByOpenId(openId);
    }

    /**
     * 根据userId 查询用户
     *
     * @param userId 用户Id
     * @return com.swust.fund.entity.User
     * @author pang
     * @date 2019/5/11
     */
    public User getUserById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    /**
     * 获取用户列表
     *
     * @param pageNum  页码
     * @param pageSize 大小
     * @return com.swust.fund.common.Page<com.swust.fund.entity.User>
     * @author pang
     * @date 2019/5/11
     */
    public Page<User> getAllUser(int pageNum, int pageSize) {
        List<User> studioList = userMapper.selectAll((pageNum - 1) * pageSize, pageSize);
        int total = userMapper.selectCount();
        return new Page<>(studioList, total, pageNum, pageSize);
    }

    /**
     * 更新用户信息
     *
     * @param user 更新后的用户信息，其中openId和userId必填
     * @return int
     * @author pang
     * @date 2019/5/11
     */
    public int editUser(User user) {
        if (user.getUserId() == null || user.getOpenId() == null) {
            throw new UnicomRuntimeException(UnicomResponseEnums.BAD_REQUEST);
        }
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
