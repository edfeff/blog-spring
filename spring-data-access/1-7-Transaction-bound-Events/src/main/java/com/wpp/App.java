package com.wpp;

import com.wpp.service.SimpleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {

//        System.setProperty("debug", "true");
        System.setProperty("logging.level.org.springframework.jdbc.datasource", "DEBUG");
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        SimpleService simpleService = context.getBean(SimpleService.class);
        simpleService.m1();
    }
}
