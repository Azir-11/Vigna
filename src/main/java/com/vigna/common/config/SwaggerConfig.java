package com.vigna.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.parameters.PathParameter;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Swagger 配置
 */
@Configuration
@Slf4j
public class SwaggerConfig {

    final String securitySchemeName = "Authorization";

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
            .components(
                new Components()
                    .addSecuritySchemes(securitySchemeName,
                        new SecurityScheme()
                            .name(securitySchemeName)
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                    )
            )
            .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
            .info(new Info().title("Vigna API")
                .description("Vigna API 接口文档")
                .version("v0.0.1")
                .license(new License().name("MIT License").url("https://opensource.org/licenses/MIT")))
            .externalDocs(new ExternalDocumentation()
                .description("no wiki")
                .url("Your own wiki or homepage"));
    }

    // 排除的Authorization的方法名
    private final Set<String> excludedAuthorizationMethodName = new HashSet<>(Arrays.asList("login", "register", "refreshToken"));

    @Bean
    public OperationCustomizer addGlobalHeaderParameter() {
        return (operation, handlerMethod) -> {
            String MethodName = handlerMethod.getMethod().getName();
            if (!excludedAuthorizationMethodName.contains(MethodName)) {
                Parameter tokenParameter = new PathParameter()
                    .in("header")
                    .name("Authorization")
                    .required(true)
                    .description("Bearer token");
                operation.addParametersItem(tokenParameter);
            }
            return operation;
        };
    }

}