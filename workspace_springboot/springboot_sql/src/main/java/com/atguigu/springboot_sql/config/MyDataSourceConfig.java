package com.atguigu.springboot_sql.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Description: <br/>
 * date: 2023/1/5$ 16:02$<br/>
 *
 * @author: lanjiwei <br/>
 */
@Deprecated
//@Configuration
public class MyDataSourceConfig {

    /**
     * 配置数据源
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl();
        return druidDataSource;
    }

}
