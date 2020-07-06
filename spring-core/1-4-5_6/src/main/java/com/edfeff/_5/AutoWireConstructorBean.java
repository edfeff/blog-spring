package com.edfeff._5;

public class AutoWireConstructorBean {
    private BeanA a;
    private BeanB b;

    public AutoWireConstructorBean(BeanA a, BeanB b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "AutoWireConstructorBean{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
