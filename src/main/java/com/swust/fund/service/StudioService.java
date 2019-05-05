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

    public Studio getById(int id) {
        return studioMapper.selectByPrimaryKey(id);
    }

    public int deleteById(int id){
        return studioMapper.deleteByPrimaryKey(id);
    }

    public int add(Studio studio){
        return studioMapper.insert(studio);
    }

    public int edit(Studio studio){
        if (studio.getStudioId()==0){
            throw new UnicomRuntimeException(UnicomResponseEnums.BAD_REQUEST);
        }
        return studioMapper.updateByPrimaryKey(studio);
    }

    public Page<Studio> getAll(int pageNum, int pageSize) {
        return new Page<>(pageNum, pageSize, new PageHandler() {
            @Override
            public List getLists() {
                int page=(pageNum-1)*pageSize;
                return studioMapper.selectAll(page,pageSize);
            }

            @Override
            public Integer getCount() {
                return studioMapper.selectCount();
            }
        });
    }

}

