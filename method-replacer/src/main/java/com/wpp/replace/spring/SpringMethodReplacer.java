package com.wpp.replace.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMethodReplacer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/wpp/replace/spring/SpringMethodReplacer.xml");
        SourceBean bean = context.getBean("bean", SourceBean.class);
        String demo = bean.hello("demo");
        System.out.println(demo);
    }

}
