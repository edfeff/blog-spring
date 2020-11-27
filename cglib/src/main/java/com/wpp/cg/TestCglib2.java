package com.wpp.cg;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class TestCglib2 {
    public static void main(String[] args) {

        CallbackFilter callbackFilter = new TargetMethodCallbackFilter();
        Callback[] callbacks = new Callback[]{
                //0 方法拦截器
                new TargetInterceptor(),
                //1 无操作
                NoOp.INSTANCE,
                //2 固定值
                new TargetResultFixed()
        };


        Enhancer e = new Enhancer();
        e.setSuperclass(TargetObject.class);
        e.setCallbackFilter(callbackFilter);
        e.setCallbacks(callbacks);

        TargetObject targetObject = (TargetObject) e.create();

        System.out.println(targetObject);
        System.out.println(targetObject.method1("1"));
        System.out.println(targetObject.method2(2));
        System.out.println(targetObject.method3(3));

    }
}
