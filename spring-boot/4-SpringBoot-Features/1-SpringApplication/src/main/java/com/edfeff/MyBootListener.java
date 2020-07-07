package com.edfeff;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 自定义事件监听器
 *
 * @author wangpp
 */
public class MyBootListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("MyBootListener: " + event);
    }
}
