package com.swust.fund.config;

import com.swust.fund.common.CommonConst;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;

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

    /**
     * 文件上传配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize("2MB");
        return factory.createMultipartConfig();
    }

}