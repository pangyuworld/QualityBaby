package com.swust.fund.service;

import com.swust.fund.common.Page;
import com.swust.fund.common.restful.UnicomRuntimeException;
import com.swust.fund.dao.ActivityMapper;
import com.swust.fund.entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    @Autowired
    private StudioService studioService;


    /***
     * 根据ID获取活动
     * @author pang
     * @date 19-5-7 上午10:36
     * @parm [id]
     * @return com.swust.fund.entity.Activity
     */
    public Activity getById(int id) {
        return activityMapper.selectByPrimaryKey(id);
    }

    /***
     * 根据ID删除活动
     * @author pang
     * @date 19-5-7 上午10:37
     * @parm [id]
     * @return int
     */
    public int deleteById(int id) {
        return activityMapper.deleteByPrimaryKey(id);
    }

    /***
     * 添加新的活动
     * @author pang
     * @date 19-5-7 上午10:38
     * @parm [activity]
     * @return int
     */
    public int add(Activity activity) {
        return activityMapper.insert(activity);
    }

    /***
     * 修改活动内容
     * @author pang
     * @date 19-5-7 上午10:39
     * @parm [activity]
     * @return int
     */
    public int edit(Activity activity) {
        return activityMapper.updateByPrimaryKeySelective(activity);
    }

    /***
     * 分页获取活动列表
     * @author pang
     * @date 19-5-7 上午10:41
     * @parm [pageNum, pageSize]
     * @return com.swust.fund.common.Page<com.swust.fund.entity.Activity>
     */
    public Page<Activity> getAll(int pageNum, int pageSize) {
        List<Activity> studioList = activityMapper.selectAll((pageNum - 1) * pageSize, pageSize);
        int total = activityMapper.selectCount();
        return new Page<>(studioList, total, pageNum, pageSize);
    }

    /***
     * 根据工作室ID分页获取活动列表
     * @author pang
     * @date 19-5-7 上午11:05
     * @parm [studioId, pageNum, pageSize]
     * @return com.swust.fund.common.Page<com.swust.fund.entity.Activity>
     */
    public Page<Activity> getAllByStudio(int studioId, int pageNum, int pageSize) {
        List<Activity> studioList = activityMapper.selectAllByStudio(studioId, (pageNum - 1) * pageSize, pageSize);
        int total = activityMapper.selectCount();
        return new Page<>(studioList, total, pageNum, pageSize);
    }

    /**
     * 获得用户参加的活动
     *
     * @param userId   用户ID
     * @param pageNum  页码
     * @param pageSize 大小
     * @return com.swust.fund.common.Page<com.swust.fund.entity.Studio>
     * @author pang
     * @date 2019/6/16
     */
    public Page<Activity> getByUserId(int userId, int pageNum, int pageSize) {
        List<Activity> studioList = activityMapper.selectByUserId(userId, (pageNum - 1) * pageSize, pageSize);
        int total = activityMapper.selectCountByUserId(userId);
        return new Page<>(studioList, total, pageNum, pageSize);
    }

    /**
     * 加入活动
     *
     * @param activityId 活动ID
     * @param userId     用户ID
     * @return int
     * @author pang
     * @date 2019/6/16
     */
    public int signIn(int activityId, int userId) {
        // TODO 如果用户没有报名相关的工作室，那么他就不能报名这个活动
        if (studioService.inTheList(activityMapper.selectByPrimaryKey(activityId).getStudioId(), userId)) {
            return activityMapper.signInActivity(activityId, userId, new Date());
        } else {
            return 0;
        }
    }

    /**
     * 退出活动
     *
     * @param activityId 活动Id
     * @param userId     用户ID
     * @return int
     * @author pang
     * @date 2019/6/16
     */
    public int signOut(int activityId, int userId) {
        return activityMapper.signOutActivity(activityId, userId);
    }
}
