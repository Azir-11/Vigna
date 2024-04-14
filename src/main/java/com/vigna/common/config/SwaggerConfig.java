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
import java.util.List;

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
                .info(new Info().title("上流男士高端发言记录系统")
                        .description("管理记录高端IT男士的优雅发言")
                        .version("v0.0.1")
                        .license(new License().name("私有项目，不允许任何借鉴或商用").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("上流男士高端发言管理 Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
    }

    @Bean
    public OperationCustomizer addGlobalHeaderParameter() {
        return (operation, handlerMethod) -> {
            // 排除的接口列表
            List<String> excludeSummary = Arrays.asList("用户注册", "用户登录");

            // 获取当前接口的Summary
            String currentSummary = operation.getSummary();

            // 如果当前接口不在排除的接口列表中，就添加token参数
            if (!excludeSummary.contains(currentSummary)) {
                Parameter tokenParameter = new PathParameter().in("header").name("Authorization").required(true).description("Bearer token");
                if (operation.getParameters() == null) {
                    operation.addParametersItem(tokenParameter);
                } else if (operation.getParameters().stream().noneMatch(parameter -> parameter.getName().equals("token"))) {
                    operation.addParametersItem(tokenParameter);
                }
            }
            return operation;
        };
    }

}