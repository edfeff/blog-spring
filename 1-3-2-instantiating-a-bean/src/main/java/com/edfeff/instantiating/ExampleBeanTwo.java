package com.edfeff.instantiating;

/**
 * @author wangpp
 */
public class ExampleBeanTwo {
    private String name;

    public ExampleBeanTwo(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExampleBean{" +
                "name='" + name + '\'' +
                '}';
    }

}
