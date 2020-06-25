package com.edfeff;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Di {

    public static void main(String[] args) {
        test1();
//        test2();
//        test3();
//        test4();

    }

    private static void test1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        System.out.println("-------------------------");
        applicationContext.getBean("lazyBean1");
    }

}
