package com.swust.fund.service;

import cn.hutool.core.date.DateUtil;
import com.swust.fund.common.CommonConst;
import com.swust.fund.common.restful.SpringExceptionHandle;
import com.swust.fund.entity.Question;
import com.swust.fund.entity.User;
import com.swust.fund.utils.random.LittleUUID;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

    @Autowired
    private UserService userService;
    @Autowired
    private AspectService aspectService;

    /**
     * 上传图片
     *
     * @param file          图片文件
     * @param directoryName 图片归档名
     * @return java.util.Map
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
        Map<String, String> imgMap = new HashMap<>(5);
        imgMap.put("fileUrl", fileUrl);
        return imgMap;
    }


    @SuppressWarnings("AlibabaRemoveCommentedCode")
    public void exportExcel(HttpServletResponse response) throws IOException {
        // 标记是否是第一次遍历，第一次遍历需要添加头部
        boolean isFisrt=true;
        // 创建行的标记
        int rowIndex=0;
        // 创建workbook
        HSSFWorkbook wb = new HSSFWorkbook();
        // 设置Excel左下角信息
        HSSFSheet sheet = wb.createSheet("学生信息");
        // 获取用户列表
        List<User> userList = userService.getAllUser(1, Integer.MAX_VALUE).getList();
        // 遍历用户列表
        for (User user : userList) {
            // 创建一列数据
            HSSFRow row=sheet.createRow(rowIndex++);
            // 设置列下标
            int cellIndex=0;
            // 获取用户大维度排名
            List<Map> aspectSortList = aspectService.getAspectSortByUserId(user.getUserId());
            // 获取用户小维度排名
            List<Map> detailSortList = aspectService.getDetailSortByUserId(user.getUserId());
            // 如果是第一次就先添加标题，然后再创建一列
            if (isFisrt){
                createHead(row,aspectSortList,detailSortList);
                row=sheet.createRow(rowIndex++);
                isFisrt=false;
            }
            // 添加用户信息
            row.createCell(cellIndex++).setCellValue(user.getStuName());
            row.createCell(cellIndex++).setCellValue(user.getGender()?"男":"女");
            row.createCell(cellIndex++).setCellValue(user.getStuId());
            row.createCell(cellIndex++).setCellValue(user.getClassName());
            row.createCell(cellIndex++).setCellValue(user.getUserFrom()?"城市":"农村");
            row.createCell(cellIndex++).setCellValue(user.getTellNum());
            // 添加大维度成绩信息
            for (Map map:aspectSortList){
                row.createCell(cellIndex++).setCellValue(map.get("aspectSort").toString());
            }
            // 添加小维度成绩信息
            for(Map map:detailSortList){
                row.createCell(cellIndex++).setCellValue(map.get("detailSort").toString());
            }
        }
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=StudentInfo.xls");
        wb.write(os);
        os.flush();
        os.close();
    }


    private void createHead(HSSFRow row,List<Map> aspectSort,List<Map> detailSort){
        int cellIndex=0;
        // 设置行高
        row.setHeight((short)(20*22.5));
        row.createCell(cellIndex++).setCellValue("姓名");
        row.createCell(cellIndex++).setCellValue("性别");
        row.createCell(cellIndex++).setCellValue("学号");
        row.createCell(cellIndex++).setCellValue("班级");
        row.createCell(cellIndex++).setCellValue("户籍性质");
        row.createCell(cellIndex++).setCellValue("电话号码");
        for (Map map:aspectSort){
            row.createCell(cellIndex++).setCellValue(map.get("aspectName").toString());
        }
        for (Map map:detailSort){
            row.createCell(cellIndex++).setCellValue(map.get("detailName").toString());
        }
    }
}
