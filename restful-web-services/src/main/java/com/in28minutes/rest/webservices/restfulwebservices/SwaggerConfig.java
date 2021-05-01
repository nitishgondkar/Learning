package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//http://localhost:8080/v2/api-docs
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact("Nitish Gondkar", "https://www.in28minutes.com", "in28minutes@gmail.com");
    /*private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Awesome API Title", "Awesome Api Documentation", "1.0",
            "urn:tos", DEFAULT_CONTACT.toString(),
            "Apache 2.0", "http://www.apache.org/licences/LICENSE-2.0"
    );*/

    //Above constructor is Deprecated. Hence using below against one shown in course
    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Awesome API Title",
            "Awesome API Description",
            "1.0",
            "http://www.in28minutes.com",
            DEFAULT_CONTACT,
            "Apache 2.0",
            "http://www.apache.org/licences/LICENSE-2.0",
            new ArrayList<>()
    );

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
            Arrays.asList("application/json", "application/xml")
    );

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }
}
