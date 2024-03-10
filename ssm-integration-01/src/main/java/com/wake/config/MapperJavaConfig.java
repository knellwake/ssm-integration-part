package com.wake.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Description: 持久层dao 配置类：连接池，sqlSessionFactory,Mapper代理对象
 *  不保留外部配置文件（mybatis-config.xml），全部的mybatis的属性，使用纯JAVA代码配置。
 */
@Configuration
public class MapperJavaConfig {
    /**
     * 配置SqlSessionFactoryBean,指定连接池对象和外部配置文件即可
     * @param dataSource 需要注入连接池对象
     * @return 工厂Bean
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        //实例化SqlSessionFactory工厂
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置连接池
        sqlSessionFactoryBean.setDataSource(dataSource);

        //替代xml文件的java配置
        //settings [包裹到一个configuration对象,切记别倒错包]
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        //开启属性驼峰式映射
        configuration.setMapUnderscoreToCamelCase(true);
        //日志
        configuration.setLogImpl(Slf4jImpl.class);
        //开启resultMap自动映射
        configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);
        sqlSessionFactoryBean.setConfiguration(configuration);

        //typeAliases
        sqlSessionFactoryBean.setTypeAliasesPackage("com.wake.pojo");

        //分页插件配置
        PageInterceptor pageInterceptor = new PageInterceptor();

        Properties properties = new Properties();
        properties.setProperty("helperDialect","mysql");
        pageInterceptor.setProperties(properties);
        sqlSessionFactoryBean.addPlugins(pageInterceptor);

        return sqlSessionFactoryBean;
    }

    /**
     * 配置Mapper实例扫描工厂,配置 <mapper <package 对应接口和mapperxml文件所在的包
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //设置mapper接口和xml文件所在的共同包
        mapperScannerConfigurer.setBasePackage("com.wake.mapper");
        return mapperScannerConfigurer;
    }
}