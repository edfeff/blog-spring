package com.edfeff._6;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class CalcReplaceMethod implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        String s = (String) args[0];
        return "======" + s + "======";
    }
}
