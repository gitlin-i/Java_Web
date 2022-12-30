package com.example.api01.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "API 명세서",
                description = "API 명세서 테스트 입니다.",
                version = "v1"))
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("Authorization",
                    new SecurityScheme()
                            .name("Authorization")
                            .type(SecurityScheme.Type.APIKEY)
                            .in(SecurityScheme.In.HEADER)));

    }

    @Bean
    public GroupedOpenApi defalutapi(){
        return GroupedOpenApi.builder()
                .group("-defalut")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public GroupedOpenApi testapi(){
        return GroupedOpenApi.builder()
                .group("test")
                .pathsToMatch("/api/sample/**")
                .build();
    }



}
