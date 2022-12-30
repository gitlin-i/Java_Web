package org.zerock.b01.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import lombok.RequiredArgsConstructor;

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
                .pathsToMatch("/test/**")
                .build();
    }

    @Bean
    public GroupedOpenApi test2api(){
        return GroupedOpenApi.builder()
                .group("test2")
                .pathsToMatch("/test2/**")
                .build();
    }
    @Bean
    public GroupedOpenApi boardapi(){
        return GroupedOpenApi.builder()
                .group("board")
                .pathsToMatch("/board/**")
                .build();
    }
}
