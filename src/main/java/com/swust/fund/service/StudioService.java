package com.swust.fund.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.swust.fund.common.Page;
import com.swust.fund.common.PageHandler;
import com.swust.fund.common.restful.UnicomResponseEnums;
import com.swust.fund.common.restful.UnicomRuntimeException;
import com.swust.fund.dao.StudioMapper;
import com.swust.fund.entity.Studio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     *  根据id获取工作室
     * @author pang
     * @date 2019/5/6
     * @param id 工作室ID
     * @return com.swust.fund.entity.Studio
     */
    public Studio getById(int id) {
        return studioMapper.selectByPrimaryKey(id);
    }

    /**
     *  根据工作室ID删除工作室
     * @author pang
     * @date 2019/5/6
     * @param id 要删除的工作室id
     * @return int
     */
    public int deleteById(int id){
        return studioMapper.deleteByPrimaryKey(id);
    }

    /**
     *  添加新的工作室
     * @author pang
     * @date 2019/5/6
     * @param studio 要添加的工作室
     * @return int
     */
    public int add(Studio studio){
        return studioMapper.insert(studio);
    }

    /**
     *  修改工作室
     * @author pang
     * @date 2019/5/6
     * @param studio 要修改的工作室信息，ID必填
     * @return int
     */
    public int edit(Studio studio){
        if (studio.getStudioId()==0){
            throw new UnicomRuntimeException(UnicomResponseEnums.BAD_REQUEST);
        }
        return studioMapper.updateByPrimaryKey(studio);
    }

    /**
     *  分页获得工作室列表
     * @author pang
     * @date 2019/5/6
     * @param pageNum 页码
     * @param pageSize 大小
     * @return com.swust.fund.common.Page<com.swust.fund.entity.Studio>
     */
    public Page<Studio> getAll(int pageNum, int pageSize) {
        return new Page<>(new PageHandler(pageNum, pageSize) {
            @Override
            public List getLists() {
                return studioMapper.selectAll((this.getPageNum()-1)*this.getPageSize(),this.getPageSize());
            }

            @Override
            public Integer getCount() {
                return studioMapper.selectCount();
            }
        });
    }

}

