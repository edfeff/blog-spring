package com.edfeff.service.impl;

import com.edfeff.model.Foo;
import com.edfeff.service.FooService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * 假定FooService接口的前两个方法getFoo（String）和getFoo（String，String）必须在具有只读语义的事务上下文中运行，
 * 而其他方法insertFoo（Foo）和updateFoo（Foo ），必须在具有读写语义的事务上下文中运行。
 * 以下几节将详细说明以下配置：
 */
public class DefaultFooService implements FooService {

    @Override
    public Foo getFoo(String fooName) {
        // ...
        System.out.println("getfoo fooName");
        Foo foo = new Foo();
        foo.setFooName(fooName);
        foo.setBarName(fooName);
        return foo;
    }

    @Override
    public Foo getFoo(String fooName, String barName) {
        System.out.println("getfoo fooName barName");

        // ...
        Foo foo = new Foo();
        foo.setBarName(barName);
        foo.setFooName(fooName);
        return foo;
    }

    @Override
    public void insertFoo(Foo foo) {
        System.out.println("insert");

        throw new UnsupportedOperationException("发出个异常");
        // ...
    }

    @Override
    public void updateFoo(Foo foo) {
        System.out.println("updateFoo");

        if (foo.getBarName() == null) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        // ...
    }
}