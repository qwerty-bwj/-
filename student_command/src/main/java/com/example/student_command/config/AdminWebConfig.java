package com.example.student_command.config;


import com.example.student_command.interceptor.LoginIntercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercept())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/teacher/login","/student/login","/css/**","/fonts/**","/images/**", "/js/**");
    }
}
