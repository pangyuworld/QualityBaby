package com.swust.fund.controller;

import com.github.pagehelper.PageInfo;
import com.swust.fund.common.restful.ResponseJSON;
import com.swust.fund.common.restful.UnicomResponseEnums;
import com.swust.fund.entity.Tag;
import com.swust.fund.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: TagController
 * @Package com.swust.fund.controller
 * @description: 标签API
 * @date 2019/7/6 14:13
 */
@Api(tags = "标签Api")
@RestController
public class TagController {
    @Autowired
    private TagService tagService;

    @ApiOperation("查找标签")
    @ApiImplicitParam(name = "tagId", value = "标签id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/tag/{tagId}", method = RequestMethod.GET)
    public ResponseJSON<Tag> getTag(@PathVariable int tagId) {
        return new ResponseJSON<>(true, tagService.getTag(tagId));
    }

    @ApiOperation("查找所有标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "大小", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "showAll", value = "是否显示全部（用户不显示全部）", required = false, dataType = "boolean", paramType = "query")
    })
    @RequestMapping(value = "/tag", method = RequestMethod.GET)
    public ResponseJSON<PageInfo<Tag>> getAllTag(int pageNum, int pageSize, boolean showAll) {
        return new ResponseJSON<>(true, tagService.getTag(pageNum, pageSize, showAll));
    }

    @ApiOperation("添加新的标签")
    @RequestMapping(value = "/tag", method = RequestMethod.POST)
    public ResponseJSON<Integer> addTag(Tag tag) {
        return new ResponseJSON<>(true, tagService.addTag(tag));
    }

    @ApiOperation("修改标签信息")
    @RequestMapping(value = "/tag", method = RequestMethod.PUT)
    public ResponseJSON<Integer> editTag(Tag tag) {
        return new ResponseJSON<>(true, tagService.editTag(tag));
    }

    @ApiOperation("删除标签")
    @RequestMapping(value = "/tag", method = RequestMethod.DELETE)
    public ResponseJSON deleteTag(Integer tagId) {
        if (tagService.deleteTag(tagId)) {
            return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
        } else {
            return new ResponseJSON(false, UnicomResponseEnums.NOT_FOUND);
        }
    }

    @ApiOperation("获取用户标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "showAll", value = "是否显示全部（用户不显示全部）", required = false, dataType = "boolean", paramType = "query")
    })
    @RequestMapping(value = "/tag/user/{userId}", method = RequestMethod.GET)
    public ResponseJSON<List<Tag>> getAllTagByUser(@PathVariable int userId, boolean showAll) {
        return new ResponseJSON<>(true, tagService.getTagByUser(userId, showAll));
    }

    @ApiOperation("获取活动标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityId", value = "活动ID", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "showAll", value = "是否显示全部（用户不显示全部）", required = false, dataType = "boolean", paramType = "query")
    })
    @RequestMapping(value = "/tag/activity/{activityId}", method = RequestMethod.GET)
    public ResponseJSON<List<Tag>> getAllTagByActivity(@PathVariable int activityId, boolean showAll) {
        return new ResponseJSON<>(true, tagService.getTagByActivity(activityId, showAll));
    }
}
