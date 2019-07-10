package com.swust.fund.service;

import com.swust.fund.dao.AspectDetailMapper;
import com.swust.fund.dao.AspectMapper;
import com.swust.fund.entity.Aspect;
import com.swust.fund.entity.AspectDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
