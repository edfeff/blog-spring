package com.edfeff.instantiating;

/**
 * @author wangpp
 */
public class InstanceFactory {

    public InstanceFactory() {
    }

    public ExampleBean exampleBean() {
        return new ExampleBean();
    }

    public ExampleBeanTwo exampleBeanTwo(String name) {
        return new ExampleBeanTwo(name);
    }

}

