package com.edfeff;

/**
 * @author wangpp
 */
public class BeanA {
    private String value;

    public BeanA() {
        System.out.println("A");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
