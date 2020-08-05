package com.wpp.listener;

import com.wpp.service.SimpleService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class ListenerOne {

    public void handle(ApplicationEvent event) {
        System.out.println("hello： " + event);
    }
}
