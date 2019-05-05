
package com.swust.fund.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Swagger2Config
 * @Package com.swust.question.config
 * @description: Swagger2配置类
 * @date 2019/3/22 15:18
 */
@Configuration
public class Swagger2Config {
    /**
     * 通过 createRestApi函数来构建一个DocketBean
     *
     * @param
     * @return springfox.documentation.spring.web.plugins.Docket
     * @author pang
     * @date 2019/3/22
     */
    @Bean
    public Docket createRestApi() {
        TypeResolver typeResolver = new TypeResolver();
        return new Docket(DocumentationType.SWAGGER_2)
                // 调用apiInfo方法创建一个实例
                .apiInfo(apiInfo())
                // 添加规则，不然swagger会递归造成严重的内存泄漏
                .select()
                // 控制暴露哪个路径下的实例，可以用@ApiIngore屏蔽
                .apis(RequestHandlerSelectors.basePackage("com.swust.fund.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建一个apiInfo接口
     *
     * @param
     * @return springfox.documentation.service.ApiInfo
     * @author pang
     * @date 2019/3/22
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 版本
                .version("1.0")
                // 标题
                .title("大学生素质发展平台接口")
                // 描述
                .description("restful接口")
                .build();
    }

    private AlternateTypeRule[] setAlternateTypeRule() {
        List<AlternateTypeRule> list = new ArrayList<>();
        return (AlternateTypeRule[]) list.toArray();
    }
}

