package com.edfeff;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

// 拒绝延时加载
//@Lazy(false)
//@Component
public class LazyInitBean {
    static {
        System.out.println("LazyInitBean class loaded");
    }

    public LazyInitBean() {
        System.out.println("LazyInitBean instance init");
    }
}
