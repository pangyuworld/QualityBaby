package com.swust.fund.controller;

import com.swust.fund.common.Page;
import com.swust.fund.common.restful.ResponseJSON;
import com.swust.fund.common.restful.UnicomResponseEnums;
import com.swust.fund.entity.Studio;
import com.swust.fund.service.StudioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pang
 * @version V1.0
 * @ClassName: StudioController
 * @Package com.swust.fund.controller
 * @description: 工作室API
 * @date 2019/5/5 11:12
 */
@Api(tags = "工作室API")
@RestController
public class StudioController {

    @Autowired
    private StudioService studioService;

    @ApiOperation("查找单个工作室")
    @ApiImplicitParam(name = "id", value = "工作室id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/studio/{id}", method = RequestMethod.GET)
    public ResponseJSON<Studio> getById(@PathVariable int id) {
        return new ResponseJSON<>(true, studioService.getById(id));
    }

    @ApiOperation("分页查找工作室")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "大小", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/studio", method = RequestMethod.GET)
    public ResponseJSON<Page<Studio>> getAll(int pageNum, int pageSize) {
        return new ResponseJSON<>(true, studioService.getAll(pageNum, pageSize));
    }

    @ApiOperation("删除工作室")
    @ApiImplicitParam(name = "id", value = "工作室id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/studio/{id}", method = RequestMethod.DELETE)
    public ResponseJSON deleteById(@PathVariable int id) {
        return new ResponseJSON(true, studioService.deleteById(id), UnicomResponseEnums.SUCCESS_OPTION);
    }

    @ApiOperation("修改工作室")
    @RequestMapping(value = "/studio", method = RequestMethod.PUT)
    public ResponseJSON editById(Studio studio) {
        return new ResponseJSON(true, studioService.edit(studio), UnicomResponseEnums.SUCCESS_OPTION);
    }

    @ApiOperation("添加工作室")
    @RequestMapping(value = "/studio", method = RequestMethod.POST)
    public ResponseJSON add(Studio studio) {
        return new ResponseJSON(true, studioService.add(studio), UnicomResponseEnums.SUCCESS_OPTION);
    }
}
