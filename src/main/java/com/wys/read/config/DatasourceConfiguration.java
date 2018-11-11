//package com.wys.read.config;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
///**
// * @Author: wys
// * @Description:
// * @Date: Created in 9:40 2018/10/6
// * @Modified By:
// */
//@Configuration
//public class DatasourceConfiguration {
//
//    @Bean(name = "dataSource")
//    @ConfigurationProperties(prefix = "c3p0")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
//    }
//
//
//}


// 不用此连接了 直接用jpa的连接