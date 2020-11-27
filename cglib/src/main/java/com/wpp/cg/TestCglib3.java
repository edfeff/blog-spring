package com.wpp.cg;

/**
 * 测试懒加载
 */
public class TestCglib3 {
    public static void main(String[] args) {
        System.out.println("-----------------1-----------------");
        LazyBean lazyBean = new LazyBean("demo", 212);
        System.out.println("-----------------2----------------");
        lazyBean.getAge();
        lazyBean.getName();

        System.out.println("-----------------3----------------");
        PropertyBean p = lazyBean.getPropertyBean();
        System.out.println("-----------------3.1----------------");
        System.out.println(p);
        System.out.println("-----------------3.2----------------");
        System.out.println(p);


        System.out.println("-----------------4----------------");
        PropertyBean p1 = lazyBean.getPropertyBeanDispatcher();
        System.out.println("-----------------4.1----------------");
        System.out.println(p1);

        System.out.println("-----------------4.2----------------");
        System.out.println(p1);

        System.out.println("-----------------5----------------");
        PropertyBean p2 = lazyBean.getPropertyBeanDispatcher();
        System.out.println("-----------------5.1----------------");
        System.out.println(p2);

        System.out.println("-----------------6----------------");
        PropertyBean p3 = lazyBean.getPropertyBeanDispatcher();
        System.out.println("-----------------6.1----------------");
        System.out.println(p3);

        System.out.println("-----------------7----------------");


    }
}
