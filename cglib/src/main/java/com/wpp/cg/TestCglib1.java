package com.wpp.cg;

import net.sf.cglib.proxy.Enhancer;

public class TestCglib1 {
    public static void main(String[] args) {
        //这里Enhancer类是CGLib中的一个字节码增强器，它可以方便的对你想要处理的类进行扩展，以后会经常看到它。
        //首先将被代理类TargetObject设置成父类，
        // 然后设置拦截器TargetInterceptor，
        // 最后执行enhancer.create()动态生成一个代理类，
        // 并从Object强制转型成父类型TargetObject。
        Enhancer e = new Enhancer();
        e.setSuperclass(TargetObject.class);
        e.setCallback(new TargetInterceptor());

        TargetObject targetObject = (TargetObject) e.create();
        System.out.println(targetObject);
        System.out.println(targetObject.method1("1"));
        System.out.println(targetObject.method2(2));
        System.out.println(targetObject.method3(3));


    }
}
