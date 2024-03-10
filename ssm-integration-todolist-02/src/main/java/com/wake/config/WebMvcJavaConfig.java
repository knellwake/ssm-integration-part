package com.wake.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Description: springmvc 针对控制层controller的配置
 *  1. controller
 *  2. 全局异常处理器
 *  3. handlerMapper handlerAdapter
 *  4. 静态资源处理
 *  5. jsp 视图解析器前后缀
 *  6. json转换器
 *  7. 拦截器...
 */
@EnableWebMvc
@Configuration
@ComponentScan({"com.wake.controller","com.wake.exception"})
public class WebMvcJavaConfig implements WebMvcConfigurer {

    /**
     * 开启静态资源处理
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    /**
     * 前端资源加载
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/",".jsp");
    }
}