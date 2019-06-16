package com.swust.fund.service;

import com.swust.fund.common.Page;
import com.swust.fund.common.restful.UnicomResponseEnums;
import com.swust.fund.common.restful.UnicomRuntimeException;
import com.swust.fund.dao.StudioMapper;
import com.swust.fund.entity.Studio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: StudioService
 * @Package com.swust.fund.service
 * @description: 工作室事务层
 * @date 2019/5/4 19:19
 */
@Service
public class StudioService {

    @Autowired
    private StudioMapper studioMapper;

    /**
     * 根据id获取工作室
     *
     * @param id 工作室ID
     * @return com.swust.fund.entity.Studio
     * @author pang
     * @date 2019/5/6
     */
    public Studio getById(int id) {
        return studioMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据工作室ID删除工作室
     *
     * @param id 要删除的工作室id
     * @return int
     * @author pang
     * @date 2019/5/6
     */
    public int deleteById(int id) {
        return studioMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加新的工作室
     *
     * @param studio 要添加的工作室
     * @return int
     * @author pang
     * @date 2019/5/6
     */
    public int add(Studio studio) {
        return studioMapper.insert(studio);
    }

    /**
     * 修改工作室
     *
     * @param studio 要修改的工作室信息，ID必填
     * @return int
     * @author pang
     * @date 2019/5/6
     */
    public int edit(Studio studio) {
        if (studio.getStudioId() == 0) {
            throw new UnicomRuntimeException(UnicomResponseEnums.BAD_REQUEST);
        }
        return studioMapper.updateByPrimaryKeySelective(studio);
    }

    /**
     * 分页获得工作室列表
     *
     * @param pageNum  页码
     * @param pageSize 大小
     * @return com.swust.fund.common.Page<com.swust.fund.entity.Studio>
     * @author pang
     * @date 2019/5/6
     */
    public Page<Studio> getAll(int pageNum, int pageSize) {
        List<Studio> studioList = studioMapper.selectAll((pageNum - 1) * pageSize, pageSize);
        int total = studioMapper.selectCount();
        return new Page<>(studioList, total, pageNum, pageSize);
    }

    /**
     * 获得用户参加的工作室
     *
     * @param userId   用户ID
     * @param pageNum  页码
     * @param pageSize 大小
     * @return com.swust.fund.common.Page<com.swust.fund.entity.Studio>
     * @author pang
     * @date 2019/6/16
     */
    public Page<Studio> getByUserId(int userId, int pageNum, int pageSize) {
        List<Studio> studioList = studioMapper.selectByUserId(userId, (pageNum - 1) * pageSize, pageSize);
        int total = studioMapper.selectCountByUserId(userId);
        return new Page<>(studioList, total, pageNum, pageSize);
    }

    /**
     * 加入工作室
     *
     * @param studioId 工作室ID
     * @param userId   用户ID
     * @return int
     * @author pang
     * @date 2019/6/16
     */
    public int signIn(int studioId, int userId) {
        return studioMapper.signInStudio(studioId, userId, new Date());
    }

    /**
     * 退出工作室
     *
     * @param studioId 工作室ID
     * @param userId   用户ID
     * @return int
     * @author pang
     * @date 2019/6/16
     */
    public int signOut(int studioId, int userId) {
        return studioMapper.signOutStudio(studioId, userId);
    }
}

