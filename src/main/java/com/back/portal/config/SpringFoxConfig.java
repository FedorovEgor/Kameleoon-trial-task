package com.back.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.back.portal"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Kameleoon trial task",
                "API endpoints for third party developers",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Egor Fedorov", "https://github.com/FedorovEgor","fedorov.egor.work@gmail.com"),
                "API Licence",
                "https://github.com/FedorovEgor",
                Collections.emptyList()
        );
    }

}
