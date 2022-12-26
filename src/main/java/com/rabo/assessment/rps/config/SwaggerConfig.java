package com.rabo.assessment.rps.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author Maryam Tavakoli on 22/12/2022
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfo(
                                "GAME: ROCK, PAPER and SCISSORS",
                                "RESTful APIs",
                                "0.0.1",
                                null,
                                new Contact(
                                        "Maryam Tavakoli",
                                        null,
                                        "Maryam@Techspire.nl"),
                                null,
                                null,
                                new ArrayList<>()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rabo.assessment.rps"))
                .build();
    }
}
