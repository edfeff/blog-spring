package com.edfeff.instantiating;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NamedBean {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        Object inner = applicationContext.getBean("inner"); //com.edfeff.instantiating.Source$Inner@305fd85d
        System.out.println(inner);
        System.out.println(applicationContext.getType("inner"));//class com.edfeff.instantiating.Source$Inner
    }


    private static void test1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        Object source = applicationContext.getBean("source");
        Object sourceA = applicationContext.getBean("sourceA");
        Object sourceB = applicationContext.getBean("sourceB");
        Object sourceC = applicationContext.getBean("sourceC");
        Object sourceD = applicationContext.getBean("sourceD");
        Object sourceE = applicationContext.getBean("sourceE");
        Object sourceF = applicationContext.getBean("sourceF");
        Object sourceG = applicationContext.getBean("sourceG");
        Object source2 = applicationContext.getBean("source2");
        Object source3 = applicationContext.getBean("source3");
        System.out.println(source);
        System.out.println(sourceA);
        System.out.println(sourceB);
        System.out.println(sourceC);
        System.out.println(sourceD);
        System.out.println(sourceE);
        System.out.println(sourceF);
        System.out.println(sourceG);
        System.out.println(source2);
        System.out.println(source3);
    }

}
