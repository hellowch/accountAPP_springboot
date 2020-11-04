package com.example.config;

import com.example.Interceptors.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//拦截器，通过token认证进行拦截
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/inaccount/**")
                .addPathPatterns("/outaccount/**")//拦截部分
                .excludePathPatterns("/user/**")   //放行部分
        ;
    }
}
