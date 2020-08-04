package com.wpp.service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.function.Consumer;

public class SimpleService {
    private TransactionTemplate transactionTemplate;
    private WorkerService wokerService;


    public WorkerService getWokerService() {
        return wokerService;
    }

    public void setWokerService(WorkerService wokerService) {
        this.wokerService = wokerService;
    }

    public SimpleService(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public Object service() {
        return transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                Object result = null;
                try {

                    result = wokerService.doWork();

                } catch (Throwable throwable) {

                    System.out.println("回滚事务");

                    status.setRollbackOnly();

                }

                return result;
            }
        });
    }

    public void otherService() {
        transactionTemplate.executeWithoutResult(new Consumer<TransactionStatus>() {
            @Override
            public void accept(TransactionStatus transactionStatus) {
                try {

                    wokerService.work();

                } catch (Throwable throwable) {

                    transactionStatus.setRollbackOnly();

                }
            }
        });

    }
}
