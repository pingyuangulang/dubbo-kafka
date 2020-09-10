package com.five.monkey.test.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置类
 *
 * @author jim
 * @date 2020/9/10 12:17
 */
@Configuration
@EnableSwagger2
@ConditionalOnExpression("${swagger.enable:true}")
public class SwaggerConfig {
    @Bean
    public Docket swaggerSpringMvcPlugin() {
        ApiInfo apiInfo = new ApiInfoBuilder().title("spring-boot-swagger-demo").description("Spring Boot + Swagger2 demo")
                .version("0.0.1-SNAPSHOT").license("author：jim").licenseUrl("https://github.com/pingyuangulang/dubbo-kafka.git")
                .build();
        return new Docket(DocumentationType.SWAGGER_2).select().build().apiInfo(apiInfo).useDefaultResponseMessages(false);
    }
}
