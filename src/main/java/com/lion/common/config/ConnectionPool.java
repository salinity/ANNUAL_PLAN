package com.lion.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/12/19.
 */
@Component
public class ConnectionPool {

    @Autowired
    private Environment environment;

    // destroyMethod = "close"的作用是数据库不连接时把连接放到数据库中方便下次使用
    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        dataSource.setInitialSize(2);// 初始化时简历物理连接的个数
        dataSource.setMaxActive(20);// 最大连接池数量
        dataSource.setMinIdle(0);// 最小连接池数量
        dataSource.setMaxWait(60000);// 获取连接时最大等待时间，单位毫秒
        dataSource.setValidationQuery("SELECT 1");// 用来检测连接是否有效的sql
        dataSource.setTestOnBorrow(false);// 申请连接时执行validationQuery检测连接是否有效
        dataSource.setTestWhileIdle(true);// 保证安全性
        dataSource.setPoolPreparedStatements(false);// 是否缓存preparedStatements,也就是PSCache
        System.out.println(">>>>>>>>>>>>>>>>ConnectionPool is success");
        return  dataSource;
    }
}
