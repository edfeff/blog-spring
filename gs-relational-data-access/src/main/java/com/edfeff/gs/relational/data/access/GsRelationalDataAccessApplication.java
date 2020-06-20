package com.edfeff.gs.relational.data.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class GsRelationalDataAccessApplication {
    private static final Logger log = LoggerFactory.getLogger(GsRelationalDataAccessApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GsRelationalDataAccessApplication.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Bean
    public CommandLineRunner mysql() {
        return args -> {
            log.info("mysql");
            log.info("创建表格");
            jdbcTemplate.execute("DROP TABLE  IF EXISTS customers  ");
            jdbcTemplate.execute("create table customers(id int(11) primary key auto_increment,first_name varchar(255),last_name varchar(255)) ");
            log.info("插入数据");
            List<Object[]> namesList = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long")
                    .stream().map(name -> name.split(" "))
                    .collect(Collectors.toList());
            namesList.stream().forEach(nameArr -> log.info(String.format("Insert customer record for %s %s", nameArr[0], nameArr[1])));

            jdbcTemplate.batchUpdate("insert  into customers(first_name,last_name) values(?,?)", namesList);
            log.info("查询数据");
            jdbcTemplate.query("select id ,first_name,last_name from customers where first_name = ?",
                    new Object[]{"John"}, (resultSet, i) -> new Customer(
                            resultSet.getLong("id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name")
                    )
            ).forEach(customer -> log.info(customer.toString()));
        };
    }

    //    @Bean
    public CommandLineRunner jdbc() {
        return args -> {
            log.info("创建表格");
            jdbcTemplate.execute("DROP table customers IF EXISTS");
            jdbcTemplate.execute("CREATE table customers(id SERIAL,first_name VARCHAR(255),last_name VARCHAR(255))");


            log.info("插入数据");
//            切分数据
            List<Object[]> namesList = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long")
                    .stream().map(name -> name.split(" "))
                    .collect(Collectors.toList());
            namesList.stream().forEach(nameArr -> log.info(String.format("Insert customer record for %s %s", nameArr[0], nameArr[1])));

            jdbcTemplate.batchUpdate("INSERT INTO customers(first_name,last_name) VALUES (?,?)", namesList);


            log.info("查询数据");
            jdbcTemplate.query("select id ,first_name,last_name from customers where first_name = ?",
                    new Object[]{"John"}, new RowMapper<Customer>() {
                        @Override
                        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                            return new Customer(
                                    resultSet.getLong("id"),
                                    resultSet.getString("first_name"),
                                    resultSet.getString("last_name")
                            );
                        }
                    }
            ).forEach(customer -> log.info(customer.toString()));
        };
    }
}
