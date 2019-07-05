package com.swust.fund.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.swust.fund.common.restful.UnicomRuntimeException;
import com.swust.fund.dao.ActivityGroupMapper;
import com.swust.fund.dao.ActivityMapper;
import com.swust.fund.entity.Activity;
import com.swust.fund.entity.ActivityGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ActivityService
 * @Package com.swust.fund.service
 * @description: 活动和活动分组的事物类
 * @date 2019/7/5 15:50
 */
@Service
public class ActivityService {
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ActivityGroupMapper groupMapper;

    /**
     * 查找所有活动
     *
     * @param pageSize 每页大小
     * @param pageNum  页码
     * @return com.github.pagehelper.PageInfo<com.swust.fund.entity.Activity> 分页后的活动
     * @author pang
     * @date 2019/7/5
     */
    public PageInfo<Activity> getActivity(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Activity> activities = activityMapper.selectAllActivity();
        return new PageInfo<>(activities);
    }

    /**
     * 查找指定活动
     *
     * @param activityId 活动id
     * @return com.swust.fund.entity.Activity 活动信息
     * @author pang
     * @date 2019/7/5
     */
    public Activity getActivity(int activityId) {
        return setGroup(activityMapper.selectByPrimaryKey(activityId));
    }

    /**
     * 查找所有活动分组
     *
     * @param pageNum 每页大小
     * @param pageNum 页码
     * @return com.github.pagehelper.PageInfo<com.swust.fund.entity.ActivityGroup>
     * @author pang
     * @date 2019/7/5
     */
    public PageInfo<ActivityGroup> getGroup(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<ActivityGroup> groups = groupMapper.selectAllGroup();
        return new PageInfo<>(groups);
    }

    /**
     * 添加新的活动
     *
     * @param activity 新的活动
     * @return java.lang.Integer
     * @author pang
     * @date 2019/7/5
     */
    public Integer addActivity(Activity activity) throws UnicomRuntimeException {
        activity.setActivityStartSignUp(new Date());
        return activityMapper.insert(activity);
    }

    /**
     * 添加新的活动分组
     *
     * @param activityGroup 新的活动分组
     * @return java.lang.Integer
     * @throws UnicomRuntimeException 添加操作出错将会抛出异常
     * @author pang
     * @date 2019/7/5
     */
    public Integer addGroup(ActivityGroup activityGroup) throws UnicomRuntimeException {
        activityGroup.setGroupAddTime(new Date());
        return groupMapper.insert(activityGroup);
    }

    /**
     * 查找指定活动分组
     *
     * @param groupId 活动分组id
     * @return com.swust.fund.entity.ActivityGroup 活动分组信息
     * @author pang
     * @date 2019/7/5
     */
    public ActivityGroup getGroup(int groupId) {
        return groupMapper.selectByPrimaryKey(groupId);
    }


    /**
     * 设置活动下的分组实体
     *
     * @param activitie 活动实体
     * @return Activity 活动实体
     * @author pang
     * @date 2019/7/5
     */
    private Activity setGroup(Activity activitie) {
        activitie.setGroup(activityMapper.selectGroup(activitie.getGroupId()));
        return activitie;
    }

    /**
     * 设置活动下的分组实体
     *
     * @param activities 活动实体
     * @return com.github.pagehelper.Page<com.swust.fund.entity.Activity> 活动实体
     * @author pang
     * @date 2019/7/5
     */
    private Page<Activity> setGroups(Page<Activity> activities) {
        List<Integer> groupIdList = activities.stream().map(Activity::getGroupId).collect(Collectors.toList());
        Map<Integer, ActivityGroup> groupMap = activityMapper.selectGroupByList(groupIdList)
                .stream()
                .collect(Collectors.toMap(ActivityGroup::getGroupId, activityGroup -> activityGroup));
        for (Activity a : activities) {
            a.setGroup(groupMap.get(a.getGroupId()));
        }
        return activities;
    }
}
