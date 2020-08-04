package com.edfeff;

import com.edfeff.service.FooService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTransactionOrderTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("AopTransactionOrderTest.xml", AopTransactionOrderTest.class);
        FooService fooService = (FooService) applicationContext.getBean("fooService");
        fooService.getFoo("111");
    }
}
