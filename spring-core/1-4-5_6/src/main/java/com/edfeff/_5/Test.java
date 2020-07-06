package com.edfeff._5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    private static void test4() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application4.xml");
        AutoWireArrayBean bean = context.getBean(AutoWireArrayBean.class);
        System.out.println(bean.toString());
    }

    private static void test3() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application3.xml");
        AutoWireNameBean bean = context.getBean(AutoWireNameBean.class);
        System.out.println(bean.toString());
    }

    private static void test2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application2.xml");
        AutoWireArrayBean bean = context.getBean(AutoWireArrayBean.class);
        System.out.println(bean.toString());

    }

    private static void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        AutoWireConstructorBean bean = context.getBean(AutoWireConstructorBean.class);
        System.out.println(bean.toString());
    }
}
