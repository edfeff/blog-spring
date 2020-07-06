package com.edfeff;

/**
 * @author wangpp
 */
public class BeanB {
    private BeanA a;

    public BeanB(BeanA a) {
        this.a = a;
        System.out.println("B");
    }

    public BeanA getA() {
        return a;
    }

    public void setA(BeanA a) {
        this.a = a;
    }
}
