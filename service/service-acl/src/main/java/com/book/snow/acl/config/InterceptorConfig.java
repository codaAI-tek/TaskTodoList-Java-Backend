package com.book.snow.acl.config;


import com.book.snow.acl.intercaptor.TokenFilterInterCaptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor getMyTokenInterCaptor(){
        return new TokenFilterInterCaptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getMyTokenInterCaptor())
                .addPathPatterns("/**") //拦截范围
                .excludePathPatterns("//swagger-resources/**","/webjars/**","/doc.html#/**","/doc.html/**","/admin/acl/user/login","/user/signup","/oauth/render/**","/oauth/callback/**","/user/test","/plugin/auth/**");
    }

}
