package com.wake.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Description: 业务层配置类 service、AOP、tx
 *  1. service
 *  2. 开启AOP注解的支持 aspect ： @Before @After @AfterReturning @AfterThrowing @Around @Aspect @Order
 *  3. tx 声明式事务管理 ： 1. 对应的事务管理器实现[TransactionManager DataSource ...]  2. 开启事务注解支持 @Transactional
 */
@Configuration
@EnableAspectJAutoProxy //aop注解支持
@EnableTransactionManagement // tx注解支持
@ComponentScan("com.wake.service")
public class ServiceJavaConfig {
    @Bean
    public TransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}