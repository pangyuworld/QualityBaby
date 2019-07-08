package com.swust.fund.config;

import com.swust.fund.common.CommonConst;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author pang
 * @version V1.0
 * @ClassName: FileServerConfig
 * @Package com.swust.fund.config
 * @description: spring 用来做图片服务器的配置
 * @date 2019/7/8 19:08
 */
@Configuration
public class FileServerConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(CommonConst.imgServerPath + "**")
                .addResourceLocations("file:" + CommonConst.uploadPath);
        super.addResourceHandlers(registry);
    }

}