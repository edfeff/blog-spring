package com.edfeff.instantiating;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstantiatingABeanApplication {

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();

    }

    private static void test3() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("instanceFactory.xml");

        InstanceFactory instanceFactory = applicationContext.getBean("instanceFactory", InstanceFactory.class);
        ExampleBean exampleBean = applicationContext.getBean("exampleBean", ExampleBean.class);
        ExampleBeanTwo exampleTwoBean = applicationContext.getBean("exampleTwoBean", ExampleBeanTwo.class);

        System.out.println(instanceFactory);
        System.out.println(exampleBean);
        System.out.println(exampleTwoBean);

        System.out.println(applicationContext.getType("instanceFactory")); //InstanceFactory
        System.out.println(applicationContext.getType("exampleBean")); // ExampleBean
        System.out.println(applicationContext.getType("exampleTwoBean"));//ExampleBeanTwo
    }

    private static void test2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("staticFactory.xml");

        StaticFactory staticFactory = applicationContext.getBean("staticFactory", StaticFactory.class);
        ExampleBean exampleBean = applicationContext.getBean("exampleBean", ExampleBean.class);
        ExampleBeanTwo exampleTwoBean = applicationContext.getBean("exampleTwoBean", ExampleBeanTwo.class);

        System.out.println(staticFactory);
        System.out.println(exampleBean);
        System.out.println(exampleTwoBean);

        System.out.println(applicationContext.getType("staticFactory")); //StaticFactory
        System.out.println(applicationContext.getType("exampleBean")); // ExampleBean
        System.out.println(applicationContext.getType("exampleTwoBean"));//ExampleBeanTwo
    }

    /**
     * 构造函数初始化
     */
    private static void test1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("exampleBean.xml");

        ExampleBean exampleBean = applicationContext.getBean("exampleBean", ExampleBean.class);
        ExampleBeanTwo exampleBeanTwo = applicationContext.getBean("exampleBeanTwo", ExampleBeanTwo.class);

        System.out.println(exampleBean.toString());
        System.out.println(exampleBeanTwo.toString());

        System.out.println(applicationContext.getType("exampleBean"));//class com.edfeff.instantiating.ExampleBean
        System.out.println(applicationContext.getType("exampleBeanTwo"));//class com.edfeff.instantiating.ExampleBeanTwo
    }
}
