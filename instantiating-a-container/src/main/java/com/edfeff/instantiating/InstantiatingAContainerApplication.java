package com.edfeff.instantiating;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstantiatingAContainerApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
        PetStoreServiceImpl petStore = applicationContext.getBean("petStore", PetStoreServiceImpl.class);
        System.out.println(petStore);
    }

}
