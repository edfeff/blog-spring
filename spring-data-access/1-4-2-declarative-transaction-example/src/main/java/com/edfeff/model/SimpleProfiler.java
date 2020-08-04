package com.edfeff.model;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.Ordered;
import org.springframework.util.StopWatch;

/**
 * 一个计时的切面
 */
public class SimpleProfiler implements Ordered {
    private int order;

    @Override
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Object profile(ProceedingJoinPoint call) throws Throwable {
        Object result;
        StopWatch watch = new StopWatch(getClass().getName());
        try {

            watch.start(call.toShortString());
            result = call.proceed();

        } finally {
            watch.stop();
            System.out.println(watch.prettyPrint());
        }
        return result;
    }

}
