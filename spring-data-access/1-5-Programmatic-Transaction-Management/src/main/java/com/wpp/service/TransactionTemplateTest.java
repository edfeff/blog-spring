package com.wpp.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTemplateTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("TransactionTemplateTest.xml", TransactionTemplateTest.class);
        SimpleService simpleService = context.getBean("simpleService", SimpleService.class);
        Object obj = simpleService.service();

        simpleService.otherService();

        System.out.println(obj);
    }

}
