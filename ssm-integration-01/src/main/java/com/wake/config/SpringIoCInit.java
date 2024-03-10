package com.wake.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Description: ioc容器 初始化
 */
public class SpringIoCInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    //指定root容器对应的配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{MapperJavaConfig.class, ServiceJavaConfig.class, DataSourceJavaConfig.class};
    }

    //指定web容器对应的配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebMvcJavaConfig.class};
    }

    //指定dispatcherServlet处理路径，通常为 /
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}