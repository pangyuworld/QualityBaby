package com.swust.fund.config;

import com.swust.fund.interceptor.TokenInterceptor;
import com.swust.fund.interceptor.WxRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author pang
 * @version V1.0
 * @ClassName: TokenConfig
 * @Package com.swust.question.config
 * @description: 拦截器注册中心
 * @date 2019/4/7 9:40
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Autowired
    private TokenInterceptor tokenInterceptor;
    @Autowired
    private WxRequestInterceptor wxRequestInterceptor;

    /**
     * 添加token拦截器
     *
     * @param registry
     * @return void
     * @author pang
     * @date 2019/4/7
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
        registry.addInterceptor(wxRequestInterceptor)
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //swagger增加url映射
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
