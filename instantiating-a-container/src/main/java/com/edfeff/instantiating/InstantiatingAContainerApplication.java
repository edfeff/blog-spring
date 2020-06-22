package com.edfeff.instantiating;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class InstantiatingAContainerApplication {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
    }

    /**
     * 1.2.3 使用容器
     */
    private static void test3() {
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        new XmlBeanDefinitionReader(applicationContext).loadBeanDefinitions("application.xml");
        applicationContext.refresh();
        PetStoreServiceImpl petStore = applicationContext.getBean("petStore", PetStoreServiceImpl.class);
        System.out.println(petStore);
    }

    /**
     * 基于XML的配置元数据
     */
    private static void test2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        PetStoreServiceImpl petStore = applicationContext.getBean("petStore", PetStoreServiceImpl.class);
        System.out.println(petStore);
    }

    /**
     * 1.2.2 实例化容器
     */
    private static void test1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("service/services.xml", "dao/daos.xml");
        PetStoreServiceImpl petStore = applicationContext.getBean("petStore", PetStoreServiceImpl.class);
        System.out.println(petStore);
    }

}
