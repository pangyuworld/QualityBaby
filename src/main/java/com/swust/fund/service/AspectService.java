package com.swust.fund.service;

import com.swust.fund.dao.AspectDetailMapper;
import com.swust.fund.dao.AspectMapper;
import com.swust.fund.entity.Aspect;
import com.swust.fund.entity.AspectDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 查找用户排名，返回包含了总数和排名的字典
     * @author pang
     * @date 2019/9/7
     * @param userId
     * @return java.util.Map<java.lang.String,java.lang.String>
     */
    public Map<String,String> gerSortByUserId(int userId){
        List<Map> result=detailMapper.selectAllUserScore();
        Map<String,String> resultMap=new HashMap<>(5);
        for (int i=0;i<result.size();i++){
            if (result.get(i).get("userId").toString().compareTo(""+userId)==0){
                resultMap.put("total",""+result.size());
                resultMap.put("sort",""+(i+1));
                return resultMap;
            }
        }
        resultMap.put("error","没有找到该用户信息");
        return resultMap;
    }
}
