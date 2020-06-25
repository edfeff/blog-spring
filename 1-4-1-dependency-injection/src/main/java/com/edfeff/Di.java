package com.edfeff;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Di {

    public static void main(String[] args) {
        test1();
//        test2();
//        test3();
//        test4();

    }

    private static void test4() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("di-nullOrEmpty.xml");
        NullOrEmpty nullOrEmpty1 = applicationContext.getBean("nullOrEmpty1", NullOrEmpty.class);
        NullOrEmpty nullOrEmpty2 = applicationContext.getBean("nullOrEmpty2", NullOrEmpty.class);
        System.out.println(nullOrEmpty1.toString());//NullOrEmpty{value=''}
        System.out.println(nullOrEmpty2.toString());//NullOrEmpty{value='null'}
    }

    private static void test3() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("di-collection.xml");
        CollectionBean collectionBean1 = applicationContext.getBean("collectionBean1", CollectionBean.class);
        CollectionBean collectionBean2 = applicationContext.getBean("collectionBean2", CollectionBean.class);
        CollectionBean child = applicationContext.getBean("child", CollectionBean.class);
        System.out.println(child.toString());

    }

    private static void test2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("di-constructor.xml");
        PropertiesBean propertiesBean1 = applicationContext.getBean("propertiesBean1", PropertiesBean.class);
        System.out.println(propertiesBean1.getProps());//{k3=v3, k2=v2, k1=v1}
        PropertiesBean propertiesBean2 = applicationContext.getBean("propertiesBean2", PropertiesBean.class);
        System.out.println(propertiesBean2.getProps());//{k6=v6, k5=v5, k4=v4}
    }

    private static void test1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("di-order.xml");
        Object c = applicationContext.getBean("c");
        BeanC c1 = applicationContext.getBean("c1", BeanC.class);
        System.out.println(c1.getB().getA().getValue()); //outerName
    }
}
