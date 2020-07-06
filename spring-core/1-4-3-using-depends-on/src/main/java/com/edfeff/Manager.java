package com.edfeff;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author wangpp
 */
public class Manager implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy" + Manager.class.getName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init" + Manager.class.getName());
    }
}
