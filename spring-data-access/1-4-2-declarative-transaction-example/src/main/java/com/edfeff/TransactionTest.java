package com.edfeff;

import com.edfeff.model.Foo;
import com.edfeff.service.FooService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("TransactionTest.xml", TransactionTest.class);
        FooService fooService = (FooService) ctx.getBean("fooService");
        fooService.insertFoo(new Foo());
    }
}
