package com.swust.fund.utils.kaptcha;

import cn.hutool.core.codec.Base64;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author pang
 * @version V1.0
 * @ClassName: KaptchaUtil
 * @Package com.swust.question.utils.kaptcha
 * @description: 验证码工具类
 * @date 2019/4/12 16:35
 */
@Component
public class KaptchaUtil {
    @Autowired
    private Producer producer;

    /**
     * 生成验证码的BASE64编码
     *
     * @param capText 验证码字符
     * @return java.lang.String
     * @author pang
     * @date 2019/4/12
     */
    public String getKaptcha(String capText) throws IOException {
        // // 生成图片验证码字符
        // String capText=producer.createText();
        // 声明字节流
        ByteArrayOutputStream outputStream = null;
        // 讲验证码字符变成图片
        BufferedImage image = producer.createImage(capText);
        // 获取字节流
        outputStream = new ByteArrayOutputStream();
        // 编码图片
        ImageIO.write(image, "jpg", outputStream);
        // 对字节数组Base64编码
        return Base64.encode(outputStream.toByteArray());
    }
}
