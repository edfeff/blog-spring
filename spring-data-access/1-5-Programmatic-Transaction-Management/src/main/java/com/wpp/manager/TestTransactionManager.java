package com.wpp.manager;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangpp
 */
public class TestTransactionManager {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("TestTransactionManager.xml", TestTransactionManager.class);
        ManagerService managerService = applicationContext.getBean("managerService", ManagerService.class);

        managerService.work();

    }
}
