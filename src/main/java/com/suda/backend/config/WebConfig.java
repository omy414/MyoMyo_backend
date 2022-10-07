package com.suda.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.suda.backend.interceptor.*;

/**
 * @apiNote Web Config
 * @author Dratini
 * @since 2022.10.05
 * @version 1.0
 */
@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /* 실행 시, defaultInterceptor를 가져와 주입하여 사용 */
    @Autowired
    private MyoMyoInterceptor myoInterceptor;

    /* 인터셉터 추가하는 메소드 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myoInterceptor) // 인터셉터 추가
                .addPathPatterns("/main/**", "/file/**") // 적용할 패턴 추가
                .excludePathPatterns("/error", "/sync/all", "/swagger-ui/**"); // 제외할 패턴 추가
    }

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
        "classpath:/META-INF/resources/", "classpath:/resources/",
        "classpath:/static/", "classpath:/public/" };



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);

        registry.addResourceHandler("/**")
                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);

        registry.addResourceHandler("/vanilla/**")
                .addResourceLocations("classpath:/vanilla/");

            registry.addResourceHandler("/react/**")
                    .addResourceLocations("classpath:/react/")
                .resourceChain(true);
    }

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setSuffix(".html");
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseTrailingSlashMatch(true);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("forward:/index.html");
        registry.addViewController("/practice")
                .setViewName("forward:/index.html");
        registry.addViewController("/swagger-ui/")
                .setViewName("forward:/swagger-ui/index.html");
        registry.addViewController("/react")
                .setViewName("forward:/react/index.html");
        registry.addViewController("/react/{path:[^\\.]*}")
                .setViewName("forward:/react/index.html");
        registry.addViewController("/react/**/{path:[^\\.]*}")
                .setViewName("forward:/react/index.html");
    }

}