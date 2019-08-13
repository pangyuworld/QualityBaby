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
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public PageInfo<Activity> getActivity(int pageNum, int pageSize, boolean showAll) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Activity> activities = activityMapper.selectAllActivity(showAll);
        setSignInNum(activities);
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
        return setSignInNum(setGroup(activityMapper.selectByPrimaryKey(activityId)));
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
    public PageInfo<ActivityGroup> getGroup(int pageNum, int pageSize, boolean showAll) {
        PageHelper.startPage(pageNum, pageSize);
        Page<ActivityGroup> groups = groupMapper.selectAllGroup(showAll);
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
     * 修改活动信息
     *
     * @param activity 活动信息
     * @return java.lang.Integer 受影响的数据总数（一般为1或0）
     * @author pang
     * @date 2019/7/6
     */
    public Integer editActivity(Activity activity) {
        return activityMapper.updateByPrimaryKeySelective(activity);
    }

    /**
     * 修改活动分组信息
     *
     * @param activityGroup 活动分组信息
     * @return java.lang.Integer 受影响的数据总数（一般为1或0）
     * @author pang
     * @date 2019/7/6
     */
    public Integer editGroup(ActivityGroup activityGroup) {
        return groupMapper.updateByPrimaryKeySelective(activityGroup);
    }

    /**
     * 删除活动
     *
     * @param activityId 要删除的活动id
     * @return java.lang.Boolean 删除成功返回true
     * @author pang
     * @date 2019/7/6
     */
    public Boolean deleteActivity(Integer activityId) {
        if (activityMapper.deleteByPrimaryKey(activityId) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除活动分组
     *
     * @param activityGroupId 要删除的分组id
     * @return java.lang.Boolean 删除成功返回true
     * @author pang
     * @date 2019/7/6
     */
    public Boolean deleteGroup(Integer activityGroupId) {
        if (groupMapper.deleteByPrimaryKey(activityGroupId) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 查找活动分组下的活动
     *
     * @param activityGroupId 分组id
     * @param pageNum         页码
     * @param pageSize        大小
     * @return com.github.pagehelper.PageInfo<com.swust.fund.entity.Activity> 分组下的活动
     * @author pang
     * @date 2019/7/6
     */
    public PageInfo<Activity> getActivity(int activityGroupId, int pageNum, int pageSize, boolean showAll) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Activity> activities = activityMapper.selectAllActivityByGroup(activityGroupId, showAll);
        setSignInNum(activities);
        return new PageInfo<>(activities);
    }

    /**
     * 加入活动
     *
     * @param userId     用户id
     * @param activityId 活动id
     * @return java.lang.Integer
     * @author pang
     * @date 2019/7/6
     */
    public Integer signInActivity(int userId, int activityId) throws UnicomRuntimeException {
        return activityMapper.signInActivity(new Date(), userId, activityId);
    }

    /**
     * 查看用户参加的活动
     *
     * @param userId   用户id
     * @param showAll  是否显示全部
     * @param pageNum  页码
     * @param pageSize 大小
     * @return com.github.pagehelper.PageInfo<java.util.Map>
     * @author pang
     * @date 2019/7/6
     */
    public PageInfo<Map> getAllActivityByUser(Integer userId, boolean showAll, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Map> activitys = activityMapper.selectAllActivityByUser(userId, showAll);
        return new PageInfo<>(activitys);
    }

    /**
     * 退出活动
     *
     * @param userId     用户id
     * @param activityId 活动id
     * @return boolean 退出成功返回true。其他情况返回false
     * @author pang
     * @date 2019/7/8
     */
    public boolean signOutActivity(int userId, int activityId) {
        if (activityMapper.signOutActivity(userId, activityId) == 1) {
            return true;
        } else {
            return false;
        }
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
        Map<Integer, ActivityGroup> groupMap;
        Stream<ActivityGroup> stream = activityMapper.selectGroupByList(groupIdList)
                .stream();
        groupMap = stream.collect(Collectors.toMap(ActivityGroup::getGroupId, Function.identity()));
        for (Activity a : activities) {
            a.setGroup(groupMap.get(a.getGroupId()));
        }
        return activities;
    }

    /**
     * 设置活动已报名人数
     *
     * @param activities 活动列表
     * @author pang
     * @date 2019/8/12
     */
    private void setSignInNum(Page<Activity> activities) {
        for (Activity a : activities) {
            a.setActivitySignInNum(activityMapper.selectSignInNum(a.getActivityId()));
        }
    }

    /**
     *  设置活动已报名人数
     * @author pang
     * @date 2019/8/12
     * @param activitie 单个活动
     */
    private Activity setSignInNum(Activity activitie) {
        activitie.setActivitySignInNum(activityMapper.selectSignInNum(activitie.getActivityId()));
        return activitie;
    }

}
