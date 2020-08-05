package com.wpp.service;

import com.wpp.listener.ListenerOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class SimpleService {
    @Autowired
    WorkService workService;

    @Transactional
//    @TransactionalEventListener(classes = ListenerOne.class, phase = TransactionPhase.BEFORE_COMMIT)
    public void m1() {
        System.out.println("h1");

        workService.dowork();
    }
}
