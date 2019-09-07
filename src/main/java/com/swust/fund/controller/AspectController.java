package com.swust.fund.controller;

import com.swust.fund.common.restful.ResponseJSON;
import com.swust.fund.common.restful.UnicomResponseEnums;
import com.swust.fund.entity.Aspect;
import com.swust.fund.entity.AspectDetail;
import com.swust.fund.service.AspectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author pang
 * @version V1.0
 * @ClassName: AspectController
 * @Package com.swust.fund.controller
 * @description: 雷达图API
 * @date 2019/7/10 8:50
 */
@Api(tags = "雷达图API")
@RestController
public class AspectController {
    @Autowired
    private AspectService aspectService;

    @ApiOperation("获取单个大方向")
    @ApiImplicitParam(name = "aspectId", value = "大方向id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/aspect/{aspectId}", method = RequestMethod.GET)
    public ResponseJSON<Aspect> getAspect(@PathVariable int aspectId) {
        return new ResponseJSON<>(true, aspectService.getAspect(aspectId));
    }

    @ApiOperation("获取单个小方向")
    @ApiImplicitParam(name = "detailId", value = "小方向id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/detail/{detailId}", method = RequestMethod.GET)
    public ResponseJSON<AspectDetail> getAspectDetail(@PathVariable int detailId) {
        return new ResponseJSON<>(true, aspectService.getDetail(detailId));
    }

    @ApiOperation("获取全部大方向")
    @ApiImplicitParam(name = "showAll", value = "是否显示全部（用户不显示全部）", required = false, dataType = "boolean", paramType = "query")
    @RequestMapping(value = "/aspect", method = RequestMethod.GET)
    public ResponseJSON<List<Aspect>> getAllAspect(@RequestParam(defaultValue = "false") boolean showAll) {
        return new ResponseJSON<>(true, aspectService.getAspect(showAll));
    }

    @ApiOperation("获取全部小方向")
    @ApiImplicitParam(name = "showAll", value = "是否显示全部（用户不显示全部）", required = false, dataType = "boolean", paramType = "query")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResponseJSON<List<AspectDetail>> getAllAspectDetail(@RequestParam(defaultValue = "false") boolean showAll) {
        return new ResponseJSON<>(true, aspectService.getDetail(showAll));
    }

    @ApiOperation("添加大方向")
    @RequestMapping(value = "/aspect", method = RequestMethod.POST)
    public ResponseJSON<Integer> addAspect(Aspect aspect) {
        return new ResponseJSON<>(true, aspectService.addAspect(aspect));
    }

    @ApiOperation("添加小方向")
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ResponseJSON<Integer> addAspectDetail(AspectDetail detail) {
        return new ResponseJSON<>(true, aspectService.addDetail(detail));
    }

    @ApiOperation("修改大方向")
    @RequestMapping(value = "/aspect", method = RequestMethod.PUT)
    public ResponseJSON<Integer> editAspect(Aspect aspect) {
        return new ResponseJSON<>(true, aspectService.editAspect(aspect));
    }

    @ApiOperation("修改小方向")
    @RequestMapping(value = "/detail", method = RequestMethod.PUT)
    public ResponseJSON<Integer> editAspectDetail(AspectDetail detail) {
        return new ResponseJSON<>(true, aspectService.editDetail(detail));
    }

    @ApiOperation("删除大方向")
    @ApiImplicitParam(name = "aspectId", value = "大方向id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/aspect/{aspectId}", method = RequestMethod.DELETE)
    public ResponseJSON deleteAspect(@PathVariable int aspectId) {
        if (aspectService.deleteAspect(aspectId)) {
            return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
        } else {
            return new ResponseJSON(false, UnicomResponseEnums.NO_USER_EXIST);
        }
    }

    @ApiOperation("删除小方向")
    @ApiImplicitParam(name = "detailId", value = "小方向id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/detail/{detailId}", method = RequestMethod.DELETE)
    public ResponseJSON deleteAspectDetail(@PathVariable int detailId) {
        if (aspectService.deleteDetail(detailId)) {
            return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
        } else {
            return new ResponseJSON(false, UnicomResponseEnums.NO_USER_EXIST);
        }
    }

    @ApiOperation("根据大方向查找小方向")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aspectId", value = "大方向id", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "showAll", value = "是否显示全部（用户不显示全部）", required = false, dataType = "boolean", paramType = "query")
    })
    @RequestMapping(value = "/detail/aspect", method = RequestMethod.GET)
    public ResponseJSON<List<AspectDetail>> getAspectDetailByAspect(int aspectId, @RequestParam(defaultValue = "false") boolean showAll) {
        return new ResponseJSON<>(true, aspectService.getDetailByAspect(aspectId, showAll));
    }

    @ApiOperation("获取用户的雷达图相关因素")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/aspect/score/{userId}", method = RequestMethod.GET)
    public ResponseJSON<List<Map>> getAspectScoreByUserId(@PathVariable int userId) {
        return new ResponseJSON<>(true, aspectService.getAspectScoreByUser(userId));
    }

    @ApiOperation("获取用户的雷达图相关因素")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aspectId", value = "大方向id", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int", paramType = "path")
    })
    @RequestMapping(value = "/aspect/{aspectId}/detail/score/{userId}", method = RequestMethod.GET)
    public ResponseJSON<List<Map>> getDetailScoreByUserId(@PathVariable int userId, @PathVariable int aspectId) {
        return new ResponseJSON<>(true, aspectService.getDetailScoreByUser(userId, aspectId));
    }

    @ApiOperation("获取排名信息")
    @RequestMapping(value = "/aspect/sort/{userId}",method = RequestMethod.GET)
    public ResponseJSON<Map> getSortByUserId(@PathVariable int userId){
        return new ResponseJSON<>(true,aspectService.gerSortByUserId(userId));
    }
}
