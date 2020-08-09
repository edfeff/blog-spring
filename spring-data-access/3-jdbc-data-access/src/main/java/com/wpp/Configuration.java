package com.wpp;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@org.springframework.context.annotation.Configuration
@EnableTransactionManagement(mode = AdviceMode.PROXY, proxyTargetClass = false)
public class Configuration {
    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();

//        basicDataSource.setUrl("jdbc:mysql://localhost:3306/example?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true");
        basicDataSource.setUrl("jdbc:mysql://192.168.31.215:3306/example?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true&allowPublicKeyRetrieval=true");
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername("admin");
        basicDataSource.setPassword("admin");

        return basicDataSource;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager manage = new DataSourceTransactionManager();

        manage.setDataSource(dataSource);
        return manage;
    }
}
