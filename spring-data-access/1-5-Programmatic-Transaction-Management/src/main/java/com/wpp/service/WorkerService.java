package com.wpp.service;

public class WorkerService {
    public String doWork() {
        return "返回值";
    }

    public void work() {
        System.out.println("work");
        throw new UnsupportedOperationException("work exception");
    }
}
