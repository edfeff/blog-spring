package com.edfeff._6;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();

    }

    private static void test4() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application6.xml");
        MyValueCalculator bean = context.getBean(MyValueCalculator.class);
        String hello = bean.computeValue("hello");
        System.out.println(hello);
    }

    private static void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application5.xml");
        WrongCommandManager bean = context.getBean(WrongCommandManager.class);
        bean.process();
        bean.process();
        bean.process();
    }

    private static void test2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application5.xml");
        CommandManager bean = context.getBean(CommandManager.class);
        bean.process();
        bean.process();
        bean.process();
    }

    private static void test3() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application5.xml");
        LookupCommandManager bean = context.getBean(LookupCommandManager.class);
        bean.process();
        bean.process();
        bean.process();
    }
}
