package com.edfeff;

/**
 * @author wangpp
 */
public class BeanC {
    private BeanB b;

    public BeanC(BeanB b) {
        this.b = b;
        System.out.println("C");
    }

    public BeanB getB() {
        return b;
    }
}
