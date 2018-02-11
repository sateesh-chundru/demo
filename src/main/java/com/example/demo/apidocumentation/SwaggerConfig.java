package com.example.demo.apidocumentation;

/*
 * The goal of Swagger� is to define a standard, language-agnostic interface to REST APIs 
 * which allows both humans and computers to discover and understand the capabilities of the service 
 * without access to source code, documentation, or through network traffic inspection... 
 * further reading: http://swagger.io/
 *                  http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                                                      .apis(RequestHandlerSelectors.any())
                                                      .paths(PathSelectors.any())
                                                      .build();
    }
}
