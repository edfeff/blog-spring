package com.wpp.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.Session;

public class HelloActiveMQ {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

        QueueConnection queueConnection = connectionFactory.createQueueConnection();
        Session session = queueConnection.createSession(true, 3);

        Queue demo = session.createQueue("test");
        MessageConsumer consumer = session.createConsumer(demo);
        Message receive = consumer.receive();

        System.out.println(receive);

        receive.acknowledge();

        consumer.close();
        session.close();
        queueConnection.close();
    }
}
