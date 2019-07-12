package com.swust.fund.service;

import cn.hutool.core.date.DateUtil;
import com.swust.fund.common.CommonConst;
import com.swust.fund.common.restful.SpringExceptionHandle;
import com.swust.fund.utils.random.LittleUUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pang
 * @version V1.0
 * @ClassName: FileService
 * @Package com.swust.fund.service
 * @description: 文件事务层
 * @date 2019/7/8 17:22
 */
@Service
public class FileService {
    private static final Logger logger = LoggerFactory.getLogger(SpringExceptionHandle.class);

    /**
     * 上传图片
     *
     * @param file          图片文件
     * @param directoryName 图片归档名
     * @return java.util.Map<java.lang.String       ,       java.lang.Object>
     * @author pang
     * @date 2019/7/8
     */
    public Map<String, String> uploadImage(MultipartFile file, String directoryName) throws IOException {
        // 获取存储在本地的实际位置
        String filePath = CommonConst.uploadPath;
        // 获取文件的全称
        String fileName = file.getOriginalFilename();
        // 获取文件的类型
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        // 获取上传时间
        String fileDate = DateUtil.format(new Date(), "/yyyy/MM/dd/");
        // 生成随机字符串作为文件名
        String fileUUID = "" + LittleUUID.generateShortUuid();
        // 重命名文件
        fileName = filePath + directoryName + fileDate + fileUUID + fileType;
        // 文件的访问路径
        String fileUrl = CommonConst.imgServerPath + directoryName + fileDate + fileUUID + fileType;
        // 生成临时文件
        File uploadFile = new File(fileName);
        if (!uploadFile.getParentFile().exists()) {
            // 创建文件
            uploadFile.getParentFile().mkdirs();
        }
        try {
            // 拷贝文件
            file.transferTo(uploadFile);
        } catch (IOException e) {
            throw e;
        }
        // 构建返回结果
        Map<String, String> imgMap = new HashMap<>();
        imgMap.put("fileUrl", fileUrl);
        return imgMap;
    }

}
