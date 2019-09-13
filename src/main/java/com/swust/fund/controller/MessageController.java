package com.swust.fund.controller;

import com.github.pagehelper.PageInfo;
import com.swust.fund.common.restful.ResponseJSON;
import com.swust.fund.common.restful.UnicomResponseEnums;
import com.swust.fund.entity.Message;
import com.swust.fund.service.MessageService;
import com.swust.fund.utils.token.Token;
import com.swust.fund.utils.wx.WxRequest;
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
 * @ClassName: MessageController
 * @Package com.swust.fund.controller
 * @description: 留言控制器
 * @date 2019/7/8 17:00
 */
@Api(tags = "留言API")
@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @ApiOperation("查找留言")
    @ApiImplicitParam(name = "messageId", value = "留言id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/message/{messageId}", method = RequestMethod.GET)
    @Token
    @WxRequest
    public ResponseJSON<Message> getMessage(@PathVariable int messageId) {
        return new ResponseJSON<>(true, messageService.getMessage(messageId));
    }

    @ApiOperation("查找所有留言")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "大小", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "showAll", value = "是否显示全部（用户不显示全部）", required = false, dataType = "boolean", paramType = "query")
    })
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    @Token
    @WxRequest
    public ResponseJSON<PageInfo<Message>> getAllMessage(int pageNum, int pageSize, boolean showAll) {
        return new ResponseJSON<>(true, messageService.getMessage(pageNum, pageSize, showAll));
    }

    @ApiOperation("添加新的留言")
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    @WxRequest
    public ResponseJSON<Integer> addMessage(Message message) {
        return new ResponseJSON<>(true, messageService.addMessage(message));
    }

    @ApiOperation("修改留言信息")
    @RequestMapping(value = "/message", method = RequestMethod.PUT)
    @WxRequest
    public ResponseJSON<Integer> editMessage(Message message) {
        return new ResponseJSON<>(true, messageService.editMessage(message));
    }

    @ApiOperation("删除留言")
    @RequestMapping(value = "/message", method = RequestMethod.DELETE)
    @Token
    @WxRequest
    public ResponseJSON deleteMessage(Integer messageId) {
        if (messageService.deleteMessage(messageId)) {
            return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
        } else {
            return new ResponseJSON(false, UnicomResponseEnums.NOT_FOUND);
        }
    }
}
