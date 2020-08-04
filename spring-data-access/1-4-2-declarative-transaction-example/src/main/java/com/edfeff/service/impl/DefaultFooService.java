package com.edfeff.service.impl;

import com.edfeff.model.Foo;
import com.edfeff.service.BarService;
import com.edfeff.service.FooService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * 假定FooService接口的前两个方法getFoo（String）和getFoo（String，String）必须在具有只读语义的事务上下文中运行，
 * 而其他方法insertFoo（Foo）和updateFoo（Foo ），必须在具有读写语义的事务上下文中运行。
 * 以下几节将详细说明以下配置：
 */
public class DefaultFooService implements FooService {
    BarService barService;

    public DefaultFooService(BarService barService) {
        this.barService = barService;
    }

    @Override
    public Foo getFoo(String fooName) {
        // ...
        System.out.println("getfoo fooName");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Foo foo = new Foo();
        foo.setFooName(fooName);
        foo.setBarName(fooName);
//        return foo;
        throw new UnsupportedOperationException("发出get 个异常");
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

    /**
     * 内部调用的方法
     * 发生了异常，默认情况下，即使捕获该异常，该事务也是会回滚的，因为内部异常时，会将全局事务设置成RollbackOnly，只能进行回滚
     * <p>
     * 15:37:01.984 [main] DEBUG org.springframework.jdbc.datasource.DataSourceTransactionManager -
     * Global transaction is marked as rollback-only but transactional code requested commit
     * <p>
     * <p>
     * 如果需要不影响当前事务
     * 方法1： 内层服务使用 REQUIRES_NEW 传播级别。在内部服务中回滚，在外部不回滚。
     * 方法2： 外层捕获该异常的情况下，内层针对此异常设置 no-rollback-for，
     * -     -外层不捕获该异常的情况下，外层和内层都针对此异常设置 no-rollback-for，
     * 方法3： 内层服务使用 NOT_SUPPORTED  传播级别，在内部方法中不使用事务，但是外部服务必须捕获该异常，如果不捕获，则依旧在外层事务回滚
     *
     * @param foo
     */
    @Override
    public void insertFoo(Foo foo) {
        System.out.println("insert");

//        try {
        barService.barInsertFoo(foo);
//        } catch (UnsupportedOperationException e) {
//            System.out.println("catch exception");
//        }

//        throw new UnsupportedOperationException("发出个异常");
        // ...
    }

    @Override
    public void updateFoo(Foo foo) {
        System.out.println("updateFoo");

        //编程式回滚
        if (foo.getBarName() == null) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        // ...
    }
}