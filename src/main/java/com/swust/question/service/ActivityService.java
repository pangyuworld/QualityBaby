package com.swust.question.service;

import com.swust.question.common.restful.UnicomResponseEnums;
import com.swust.question.common.restful.UnicomRuntimeException;
import com.swust.question.dao.ActivityDAO;
import com.swust.question.dao.UserAndActivityDAO;
import com.swust.question.entity.Activity;
import com.swust.question.entity.UserAndActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ActivityService
 * @Package com.swust.question.service
 * @description: 活动事务层
 * @date 2019/3/23 13:30
 */
@Service
public class ActivityService {
    @Autowired
    private ActivityDAO activityDao;
    @Autowired
    private UserAndActivityDAO userAndActivityDAO;


    /**
     * 根据ID获取活动
     *
     * @param activityId 活动ID
     * @return com.swust.question.entity.Activity
     * @author pang
     * @date 2019/3/23
     */
    public Activity getActivityById(int activityId) {
        return activityDao.getOne(activityId);
    }

    /**
     * 获取所有活动列表
     *
     * @return java.util.List<com.swust.question.entity.Activity>
     * @author pang
     * @date 2019/3/23
     */
    public List<Activity> getAllActivity() {
        return activityDao.findAll();
    }

    /**
     * 分页获取所有活动列表
     *
     * @param pageNumber 页码
     * @param pageSize   页大小
     * @return java.util.List<com.swust.question.entity.Activity>
     * @author pang
     * @date 2019/3/23
     */
    public List<Activity> getAllActivity(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
        return activityDao.findAll(pageable).getContent();
    }

    /**
     * 添加新活动
     *
     * @param activity 要添加的活动实体
     * @return com.swust.question.entity.Activity
     * @author pang
     * @date 2019/3/23
     */
    public Activity addActivity(Activity activity) {
        return activityDao.save(activity);
    }

    /**
     * 编辑活动（需要活动ID）
     *
     * @param activity 编辑后的活动实体，需要活动ID
     * @return com.swust.question.entity.Activity
     * @author pang
     * @date 2019/3/23
     */
    public Activity editActivity(Activity activity) {
        if (activity.getActivityId() == 0) {
            throw new UnicomRuntimeException(UnicomResponseEnums.ILLEGAL_ARGUMENT,"id不能为空");
        }
        return activityDao.saveAndFlush(activity);
    }

    /**
     * 删除活动（需要活动ID）
     *
     * @param activity 要删除的活动实体
     * @return void
     * @author pang
     * @date 2019/3/23
     */
    public void deleteActivity(Activity activity) {
        activityDao.deleteById(activity.getActivityId());
    }

    /**
     * 根据ID删除活动
     *
     * @param activityId 要删除的活动ID
     * @return void
     * @author pang
     * @date 2019/3/23
     */
    public void deleteActivity(int activityId) {
        activityDao.deleteById(activityId);
    }

    /**
     * 根据用户ID获取活动列表，即查询用户参加的活动列表
     * @author pang
     * @date 2019/3/23
     * @param userId 用户ID
     * @return java.util.List<com.swust.question.entity.Activity>
     */
    public List<Activity> getActivityByUserId(int userId){
        List<UserAndActivity> list = userAndActivityDAO.findAllByActivity_ActivityId(userId);
        List<Activity> activityList=list.stream()
                .map(UserAndActivity::getActivity)
                .collect(Collectors.toList());
        return activityList;
    }

    /**
     *  根据用户ID获取活动列表，即查询用户参加的活动列表（分页）
     * @author pang
     * @date 2019/4/11
     * @param userId 用户id
     * @param pageNumber 页码
     * @param pageSize 大小
     * @return java.util.List<com.swust.question.entity.Activity>
     */
    public List<Activity> getActivityByUserId(int userId,int pageNumber,int pageSize){
        Pageable pageable=PageRequest.of(pageNumber-1,pageSize);
        List<UserAndActivity> list = userAndActivityDAO.findAllByUser_UserId(userId,pageable).getContent();
        List<Activity> activityList=list.stream()
                .map(UserAndActivity::getActivity)
                .collect(Collectors.toList());
        return activityList;
    }

    /**
     *  获得总数
     * @author pang
     * @date 2019/4/11
     * @param
     * @return int
     */
    public int getSumActivity(){
        return (int) activityDao.count();
    }

    /**
     *  获得条件查询以后的总数
     * @author pang
     * @date 2019/4/11
     * @param userId
     * @return int
     */
    public int getSumActivity(int userId){
        return (int)userAndActivityDAO.countByUser_UserId(userId);
    }
}
