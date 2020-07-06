package com.edfeff.gs.rest.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wpp
 */
//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class GsRestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GsRestServiceApplication.class, args);
    }

}
