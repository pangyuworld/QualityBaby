package com.swust.fund.service;

import com.swust.fund.dao.AspectDetailMapper;
import com.swust.fund.dao.AspectMapper;
import com.swust.fund.entity.Aspect;
import com.swust.fund.entity.AspectDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * @author pang
 * @version V1.0
 * @ClassName: AspectService
 * @Package com.swust.fund.service
 * @description: 雷达图事务层
 * @date 2019/7/9 10:40
 */
@Service
public class AspectService {
    @Autowired
    private AspectMapper aspectMapper;
    @Autowired
    private AspectDetailMapper detailMapper;

    /**
     * 获取一个大方向
     *
     * @param aspectId 大方向ID
     * @return com.swust.fund.entity.Aspect
     * @author pang
     * @date 2019/7/10
     */
    public Aspect getAspect(int aspectId) {
        return aspectMapper.selectByPrimaryKey(aspectId);
    }

    /**
     * 获取一个小方向
     *
     * @param detailId 小方向ID
     * @return com.swust.fund.entity.AspectDetail
     * @author pang
     * @date 2019/7/10
     */
    public AspectDetail getDetail(int detailId) {
        return detailMapper.selectByPrimaryKey(detailId);
    }

    /**
     * 获取全部大方向
     *
     * @return java.util.List<com.swust.fund.entity.Aspect>
     * @author pang
     * @date 2019/7/10
     */
    public List<Aspect> getAspect(boolean showAll) {
        return aspectMapper.selectAllAspect(showAll);
    }

    /**
     * 获取全部小方向
     *
     * @return java.util.List<com.swust.fund.entity.AspectDetail>
     * @author pang
     * @date 2019/7/10
     */
    public List<AspectDetail> getDetail(boolean showAll) {
        return detailMapper.selectAllAspectDetail(showAll);
    }

    /**
     * 添加新的大方向
     *
     * @param aspect 新的大方向
     * @return java.lang.Integer
     * @author pang
     * @date 2019/7/10
     */
    public Integer addAspect(Aspect aspect) {
        return aspectMapper.insert(aspect);
    }

    /**
     * 添加新的小方向
     *
     * @param detail 新的小方向
     * @return java.lang.Integer
     * @author pang
     * @date 2019/7/10
     */
    public Integer addDetail(AspectDetail detail) {
        return detailMapper.insert(detail);
    }

    /**
     * 修改大方向信息
     *
     * @param aspect 修改后的大方向
     * @return java.lang.Integer
     * @author pang
     * @date 2019/7/10
     */
    public Integer editAspect(Aspect aspect) {
        return aspectMapper.updateByPrimaryKeySelective(aspect);
    }

    /**
     * 修改小方向信息
     *
     * @param detail 修改后的小方向信息
     * @return java.lang.Integer
     * @author pang
     * @date 2019/7/10
     */
    public Integer editDetail(AspectDetail detail) {
        return detailMapper.updateByPrimaryKeySelective(detail);
    }

    /**
     * 删除大方向
     *
     * @param aspectId 要删除的大方向ID
     * @return java.lang.Boolean
     * @author pang
     * @date 2019/7/10
     */
    public Boolean deleteAspect(Integer aspectId) {
        if (aspectMapper.deleteByPrimaryKey(aspectId) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除小方向
     *
     * @param detailId 要删除的小方向ID
     * @return java.lang.Boolean
     * @author pang
     * @date 2019/7/10
     */
    public Boolean deleteDetail(Integer detailId) {
        if (detailMapper.deleteByPrimaryKey(detailId) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据大方向查找小方向
     *
     * @param aspectId 大方向ID
     * @param showAll  是否显示全部
     * @return java.util.List<com.swust.fund.entity.AspectDetail>
     * @author pang
     * @date 2019/7/10
     */
    public List<AspectDetail> getDetailByAspect(Integer aspectId, Boolean showAll) {
        return detailMapper.selectAllAspectDetailByAspect(aspectId, showAll);
    }

    /**
     * 获取用户的大的雷达图
     *
     * @param userId 用户Id
     * @return java.util.List<java.util.Map>
     * @author pang
     * @date 2019/7/11
     */
    public List<Map> getAspectScoreByUser(int userId) {
        return aspectMapper.selectScoreByUser(userId);
    }

    /**
     * 获取用户小的雷达图
     *
     * @param userId   用户ID
     * @param aspectId 大方向ID
     * @return java.util.List<java.util.Map>
     * @author pang
     * @date 2019/7/11
     */
    public List<Map> getDetailScoreByUser(int userId, int aspectId) {
        return detailMapper.selectDetailScoreByUser(userId, aspectId);
    }

    /**
     * 查找用户小维度排名
     *
     * @param userId 用户ID
     * @return java.util.Map
     * @author pang
     * @date 2019/9/7
     */
    public List<Map> getDetailSortByUserId(int userId) {
        List<Map> result = detailMapper.selectDetailSortByUser(userId);
        return result;
    }

    /**
     * 查找用户大维度排名
     *
     * @param userId 用户ID
     * @return java.util.List<java.util.Map>
     * @author pang
     * @date 2019/9/25
     */
    public List<Map> getAspectSortByUserId(int userId) {
        return aspectMapper.selectAspectSortByUser(userId);
    }

    /**
     * 排名小维度
     *
     * @return java.util.concurrent.Future<java.lang.String>
     * @author pang
     * @date 2019/9/24
     */
    @Async("threadPool")
    public Future<String> updateDetailSort() {
        List<Integer> detailList = detailMapper.selectAllDetailId();
        List<Map<String, Integer>> sortMapList = new LinkedList<>();
        Map<String, Integer> sortMap;
        for (int detailId : detailList) {
            List<Integer> userIdList = detailMapper.selectAllUserDetailSort(detailId);
            for (int i = 0; i < userIdList.size(); i++) {
                // 新建一个map，大小为3，不扩容（因为正好够用）
                sortMap = new HashMap<>(3, 1);
                // 添加用户id
                sortMap.put("userId", userIdList.get(i));
                // 添加小维度id
                sortMap.put("detailId", detailId);
                // 添加用户排名
                sortMap.put("detailSort", i + 1);
                // 将数据添加到链表
                sortMapList.add(sortMap);
            }
        }
        // 先清空表
        detailMapper.deleteDetailSort();
        // 在插入表
        detailMapper.updateDetailSort(sortMapList);
        return new AsyncResult<>(Thread.currentThread().getName());
    }

    /**
     * 排名大维度
     *
     * @param
     * @return java.util.concurrent.Future<java.lang.String>
     * @author pang
     * @date 2019/9/25
     */
    @Async("threadPool")
    public Future<String> updateAspectSort() {
        List<Integer> aspectList = aspectMapper.selectAllAspectId();
        List<Map<String, Integer>> sortMapList = new LinkedList<>();
        Map<String, Integer> sortMap;
        for (int aspectId : aspectList) {
            List<Integer> userIdList = aspectMapper.selectAllUserAspectSort(aspectId);
            for (int i = 0; i < userIdList.size(); i++) {
                // 新建一个map，大小为3，不扩容（因为正好够用）
                sortMap = new HashMap<>(3, 1);
                // 添加用户id
                sortMap.put("userId", userIdList.get(i));
                // 添加小维度id
                sortMap.put("aspectId", aspectId);
                // 添加用户排名
                sortMap.put("aspectSort", i + 1);
                // 将数据添加到链表
                sortMapList.add(sortMap);
            }
        }
        // 先清空表
        aspectMapper.deleteAspectSort();
        // 在插入表
        aspectMapper.updateAspectSort(sortMapList);
        return new AsyncResult<>(Thread.currentThread().getName());
    }

    /**
     * 更新成绩排名
     *
     * @return void
     * @author pang
     * @date 2019/9/25
     */
    @Async("threadPool")
    public void updateSort() {
        this.updateDetailSort();
        this.updateAspectSort();
    }
}
