package com.wpp.replace.spring;

public class SourceBean {
    public String hello(String msg) {
        System.out.println("hello");
        return "hello" + msg;
    }
}
