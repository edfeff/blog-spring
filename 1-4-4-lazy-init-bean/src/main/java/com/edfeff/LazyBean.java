package com.edfeff;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author wangpp
 */
public class LazyBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("lazy");
    }
}
