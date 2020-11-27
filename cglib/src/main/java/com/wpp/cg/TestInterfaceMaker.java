package com.wpp.cg;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InterfaceMaker;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestInterfaceMaker {
    public static void main(String[] args) throws Exception {
        InterfaceMaker interfaceMaker = new InterfaceMaker();

        interfaceMaker.add(TargetObject.class);

        Class TargetObjectInterface = interfaceMaker.create();
        for (Method method : TargetObjectInterface.getMethods()) {
            System.out.println(method.getName());
        }
        System.out.println("---------------------------------------");

        Object object = Enhancer.create(Object.class, new Class[]{TargetObjectInterface}, new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                switch (method.getName()) {
                    case "method1": {
                        System.out.println("== method1,---> 0");
                        return "method1";
                    }
                    case "method2": {
                        System.out.println("== method2,---> 1");
                        return "method2";
                    }
                    case "method3": {
                        System.out.println("== method3,---> 2");
                        return 3333;
                    }
                    default:
                        break;
                }
                return "default";
            }
        });

        Method method3 = object.getClass().getMethod("method3", new Class[]{int.class});
        int result = (int) method3.invoke(object, new Object[]{3});
        System.out.println(result);

        Method method1 = object.getClass().getMethod("method1", new Class[]{String.class});



    }
}
