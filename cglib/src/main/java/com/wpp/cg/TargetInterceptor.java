package com.wpp.cg;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class TargetInterceptor implements MethodInterceptor {
    static Set<String> notInterceptor;

    static {
        notInterceptor = new HashSet<>();
        notInterceptor.add("toString");
        notInterceptor.add("equals");
        notInterceptor.add("hashCode");
    }

    /**
     * 重写方法拦截在方法前和方法后加入业务
     * Object obj为目标对象
     * Method method为目标方法
     * Object[] params 为参数，
     * MethodProxy proxy CGlib方法代理对象
     * <p>
     * <p>
     * 参数：
     * Object为由CGLib动态生成的代理类实例，
     * Method为上文中实体类所调用的被代理的方法引用，
     * Object[]为参数值列表，
     * MethodProxy为生成的代理类对方法的代理引用。
     * <p>
     * 返回：从代理实例的方法调用返回的值。
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (notInterceptor.contains(method.getName())) {
            return proxy.invokeSuper(obj, args);
        } else {
            System.out.println("before");
            Object result = proxy.invokeSuper(obj, args);
            System.out.println("after");
            return result;
        }
    }

}
