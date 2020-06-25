package com.edfeff;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author wangpp
 */
public class RefLazyBean implements InitializingBean {
    private LazyBean lazyBean;

    public RefLazyBean() {

    }

    public void setLazyBean(LazyBean lazyBean) {
        this.lazyBean = lazyBean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("RefLazyBean");
    }
}
