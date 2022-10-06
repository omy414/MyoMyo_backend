package com.suda.backend.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.classmate.TypeResolver;
import com.suda.backend.response.ApiResErrFormat;
import com.suda.backend.response.ApiResFormat;
import com.suda.backend.response.ApiResNoAuthFormat;

import io.swagger.models.auth.ApiKeyAuthDefinition;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableWebMvc
@EnableSwagger2
@Configuration
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket api(TypeResolver typeResolver) {
        return new Docket(DocumentationType.OAS_30)
                // 실제 컨트롤러에서 리턴하지 않는 예제 클래스를 추가하고자 할 때.
                .additionalModels(
                        typeResolver.resolve(ApiResFormat.class),
                        typeResolver.resolve(ApiResErrFormat.class),
                        typeResolver.resolve(ApiResNoAuthFormat.class))
                // 멤버 변수 중, Date 관련 변수 문제로 인해 설정 추가
                .directModelSubstitute(LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(LocalDateTime.class, java.util.Date.class)
                .useDefaultResponseMessages(true)
                .apiInfo(apiInfo())
                // 인증 토큰 방식이 있을때만 사용.
                // .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.suda.backend.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("MyoMyo Backend API")
                .description("MyoMyo 프로젝트 Backend 연동 서비스 API에 대한 문서를 제공하고 설명합니다.")
                .version("1.0")
                .build();
    }

    // 인증 토큰 방식이 있을때만 사용.
    /*
     * private SecurityContext securityContext() {
     * return SecurityContext.builder()
     * .securityReferences(defaultAuth())
     * .build();
     * }
     */

    // 인증 토큰 방식이 있을때만 사용.
    /*
     * private List<SecurityReference> defaultAuth() {
     * AuthorizationScope authorizationScope = new AuthorizationScope("global",
     * "accessEverything");
     * AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
     * authorizationScopes[0] = authorizationScope;
     * return Arrays.asList(new SecurityReference("Authorization",
     * authorizationScopes));
     * }
     */

    private ApiKey apiKey() {
        return new ApiKey("apiKey", "apiKey", "header");
    }
}