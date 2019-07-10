package com.swust.fund.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.swust.fund.common.restful.UnicomResponseEnums;
import com.swust.fund.common.restful.UnicomRuntimeException;
import com.swust.fund.dao.TagMapper;
import com.swust.fund.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: TagService
 * @Package com.swust.fund.service
 * @description: 标签事务层
 * @date 2019/7/6 13:56
 */
@Service
public class TagService {
    @Autowired
    private TagMapper tagMapper;

    /**
     * 获取标签信息
     *
     * @param tagId 标签id
     * @return com.swust.fund.entity.Tag
     * @author pang
     * @date 2019/7/6
     */
    public Tag getTag(int tagId) {
        return tagMapper.selectByPrimaryKey(tagId);
    }

    /**
     * 获取全部标签信息
     *
     * @param pageNum  页码
     * @param pageSize 大小
     * @param showAll  是否显示全部
     * @return com.github.pagehelper.PageInfo<com.swust.fund.entity.Tag>
     * @author pang
     * @date 2019/7/6
     */
    public PageInfo<Tag> getTag(int pageNum, int pageSize, boolean showAll) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Tag> tags = tagMapper.selectAllTag(showAll);
        return new PageInfo<>(tags);
    }

    /**
     * 添加新标签
     *
     * @param tag 新的标签
     * @return java.lang.Integer
     * @author pang
     * @date 2019/7/6
     */
    public Integer addTag(Tag tag) {
        return tagMapper.insert(tag);
    }

    /**
     * 修改标签信息
     *
     * @param tag 修改后的标签
     * @return java.lang.Integer
     * @author pang
     * @date 2019/7/6
     */
    public Integer editTag(Tag tag) {
        return tagMapper.updateByPrimaryKeySelective(tag);
    }

    /**
     * 删除标签信息
     *
     * @param tagId 要删除的标签ID
     * @return boolean 删除成功返回true
     * @author pang
     * @date 2019/7/6
     */
    public boolean deleteTag(int tagId) {
        if (tagMapper.deleteByPrimaryKey(tagId) < 1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 获取用户标签
     *
     * @param userId  用户id
     * @param showAll 是否全部显示
     * @return java.util.List<com.swust.fund.entity.Tag>
     * @author pang
     * @date 2019/7/6
     */
    public List<Tag> getTagByUser(int userId, boolean showAll) {
        return tagMapper.selectAllTagByUser(userId, showAll);
    }

    /**
     * 获取活动标签
     *
     * @param activity 活动id
     * @param showAll  是否全部显示
     * @return java.util.List<com.swust.fund.entity.Tag>
     * @author pang
     * @date 2019/7/6
     */
    public List<Tag> getTagByActivity(int activity, boolean showAll) {
        return tagMapper.selectAllTagByActivity(activity, showAll);
    }
}
