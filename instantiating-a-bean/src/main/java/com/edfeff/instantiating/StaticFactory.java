package com.edfeff.instantiating;

/**
 * @author wangpp
 */
public class StaticFactory {
    public static StaticFactory instance = new StaticFactory();

    public static StaticFactory getInstance() {
        return new StaticFactory();
    }

    public static ExampleBean getExamplBean() {
        return new ExampleBean();
    }

    public static ExampleBeanTwo getExampleBeanTwo(String name) {
        return new ExampleBeanTwo(name);
    }
}
