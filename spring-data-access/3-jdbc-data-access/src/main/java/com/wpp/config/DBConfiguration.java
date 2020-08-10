package com.wpp.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement(mode = AdviceMode.PROXY, proxyTargetClass = false)
@EnableConfigurationProperties(value = JdbcProperties.class)
public class DBConfiguration {

    @Bean
    public DataSource dataSource(JdbcProperties jdbcProperties) {
        BasicDataSource basicDataSource = new BasicDataSource();

//        basicDataSource.setUrl("jdbc:mysql://localhost:3306/example?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true");
//        basicDataSource.setUrl("jdbc:mysql://192.168.31.215:3306/example?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true&allowPublicKeyRetrieval=true");
//        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        basicDataSource.setUsername("admin");
//        basicDataSource.setPassword("admin");

        basicDataSource.setUrl(jdbcProperties.getUrl());
        basicDataSource.setDriverClassName(jdbcProperties.getDriverClass());
        basicDataSource.setUsername(jdbcProperties.getUsername());
        basicDataSource.setPassword(jdbcProperties.getPassword());

        return basicDataSource;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager manage = new DataSourceTransactionManager();

        manage.setDataSource(dataSource);
        return manage;
    }


    @Bean
    @Qualifier("namedParameterJdbcTemplate")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(JdbcTemplate jdbcTemplate) {
        return new NamedParameterJdbcTemplate(jdbcTemplate);
    }
}
