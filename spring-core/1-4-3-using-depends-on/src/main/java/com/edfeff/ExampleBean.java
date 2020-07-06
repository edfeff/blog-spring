package com.edfeff;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author wangpp
 */
public class ExampleBean implements InitializingBean, DisposableBean {
    private Manager manager;

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy" + ExampleBean.class.getName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init" + ExampleBean.class.getName());
    }
}
