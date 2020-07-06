package com.edfeff._5;

public class AutoWireNameBean {
    private BeanA a1;
    private BeanB b2;

    public BeanA getA1() {
        return a1;
    }

    public void setA1(BeanA a1) {
        this.a1 = a1;
    }

    public BeanB getB2() {
        return b2;
    }

    public void setB2(BeanB b2) {
        this.b2 = b2;
    }

    @Override
    public String toString() {
        return "AutoWireNameBean{" +
                "a1=" + a1 +
                ", b2=" + b2 +
                '}';
    }
}
