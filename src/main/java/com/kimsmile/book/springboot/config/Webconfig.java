package com.kimsmile.book.springboot.config;

import com.kimsmile.book.springboot.config.auth.LoginUserArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class Webconfig implements WebMvcConfigurer {

    private final LoginUserArgumentResolver loginUserArgumentResolverl;

    public Webconfig(LoginUserArgumentResolver loginUserArgumentResolverl) {
        this.loginUserArgumentResolverl = loginUserArgumentResolverl;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(loginUserArgumentResolverl);
    }
}
