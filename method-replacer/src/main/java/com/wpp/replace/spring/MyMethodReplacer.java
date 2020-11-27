package com.wpp.replace.spring;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class MyMethodReplacer implements MethodReplacer {

    public MyMethodReplacer() {
    }

    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("==========before========");
        Object result = null;
        try {
            result = "xxx";
        } catch (Throwable throwable) {
            System.out.println("exception");
        } finally {
            System.out.println("finally");
        }
        System.out.println("========after===");

        return result;
    }
}
