package com.swust.fund.controller;

import com.swust.fund.common.restful.ResponseJSON;
import com.swust.fund.common.restful.UnicomResponseEnums;
import com.swust.fund.service.FileService;
import com.swust.fund.utils.token.Token;
import com.swust.fund.utils.wx.WxRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * @author pang
 * @version V1.0
 * @ClassName: FileController
 * @Package com.swust.fund.controller
 * @description: 文件Api
 * @date 2019/7/8 17:21
 */
@Api(tags = "文件相关操作API")
@RestController
public class FileController {
    @Autowired
    private FileService fileService;

    @ApiOperation("上传活动图片")
    @RequestMapping(value = "/activity/uploadImages", method = RequestMethod.POST)
    @Token
    public ResponseJSON<Map<String, String>> activityFileUpload(@RequestParam(value = "file") MultipartFile file) {
        try {
            return new ResponseJSON<>(true, fileService.uploadImage(file, "activity"), UnicomResponseEnums.FILEUPLOAD_SUCCESS);
        } catch (IOException e) {
            // throw new UnicomRuntimeException(UnicomResponseEnums.ILLEGAL_ARGUMENT, "上传失败");
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation("上传活动分组的图标")
    @RequestMapping(value = "/activity-group/uploadImages", method = RequestMethod.POST)
    @Token
    public ResponseJSON<Map<String, String>> groupFileUpload(@RequestParam(value = "file") MultipartFile file) {
        try {
            return new ResponseJSON<>(true, fileService.uploadImage(file, "group"), UnicomResponseEnums.FILEUPLOAD_SUCCESS);
        } catch (IOException e) {
            // throw new UnicomRuntimeException(UnicomResponseEnums.ILLEGAL_ARGUMENT, "上传失败");
            e.printStackTrace();
        }
        return null;
    }
}
