/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * swagger配置类
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-06-14 08:35
 */
@Component
@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan("com.zhiyun.controller")
public class Swagger2Config {
    @Bean
    public Docket createAPI() {
        return new Docket(DocumentationType.SWAGGER_2).forCodeGeneration(true).select().apis(RequestHandlerSelectors.any())
                //过滤生成链接
                .paths(PathSelectors.any()).build().apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        Contact contact = new Contact("邓艺", "www.dengyi.pro", "dengyi@dengyi.pro");
        ApiInfo apiInfo = new ApiInfoBuilder().title("晶彩 MES 项目API文档").description("API文档").contact(contact)
                .version("1.0").build();
        return apiInfo;
    }
}