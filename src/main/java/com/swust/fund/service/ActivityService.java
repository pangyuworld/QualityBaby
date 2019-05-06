package com.swust.fund.service;

import com.swust.fund.dao.ActivityMapper;
import com.swust.fund.entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ActivityService
 * @Package com.swust.fund.service
 * @description: 活动事务层
 * @date 2019/5/6 21:43
 */
@Service
public class ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    public Activity getById(int id){
        return activityMapper.selectByPrimaryKey(id);
    }

}
