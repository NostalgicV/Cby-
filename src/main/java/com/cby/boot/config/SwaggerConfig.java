package com.cby.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @ Bean
    public Docket docket2(){
        return new Docket(DocumentationType.OAS_30)
                .groupName("ABC");

    }
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .enable(true)
                .groupName("CBY")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cby.boot.controller"))
                .paths(PathSelectors.ant("/Controllers/**"))
                .build();
    }


    @SuppressWarnings("all")
    public ApiInfo apiInfo(){
        return new ApiInfo(
                "Ayuan",
                "AI project",
                "v1.0",
                "2772293135@qq.com", //开发者团队的邮箱
                "CBY",
                "Apache 2.0",  //许可证
                "http://www.baidu.com" //许可证链接
        );
    }
}