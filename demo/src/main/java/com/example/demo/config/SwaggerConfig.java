package com.example.demo.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // 标记为配置类，让Spring扫描并加载
public class SwaggerConfig {

    // 配置Swagger文档基本信息
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Demo项目API文档")  // 文档标题
                        .version("1.0")  // 版本号
                        .description("这是Demo项目的接口文档，用于前后端对接"));  // 文档描述
    }
}