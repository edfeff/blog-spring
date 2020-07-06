package com.edfeff.consuming.rest;

import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
    public static void main(String[] args) {
//        send();

        testThead();

    }

    static class SendToRedis implements Runnable {
        private BlockingQueue<EventRecord> queue;
        private Jedis jedis;
        private String list;
        private String count;

        public SendToRedis(Jedis jedis, BlockingQueue<EventRecord> queue, String list, String count) {
            this.jedis = jedis;
            this.queue = queue;
            this.list = list;
            this.count = count;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    EventRecord record = queue.take();
                    jedis.incr(count);
                    jedis.lpush(list, record.toString());
                    System.out.println("send: " + record.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    private static void testThead() {
        Jedis jedis = new Jedis("localhost", 6379);
        BlockingQueue<EventRecord> queue = new LinkedBlockingQueue<>();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                long time = (new Date()).getTime();
                try {
                    queue.put(new EventRecord("e" + i, time, time + 1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
//                    continue;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }

        }).start();
        new Thread(new SendToRedis(jedis, queue, "test", "testcount")).start();

    }

    private static void send() {
        Jedis jedis = new Jedis("localhost", 6379);
        long time = (new Date()).getTime();
        String key = "unomi-log-1";
        jedis.lpush(key, new EventRecord("test", time, time + 1000).toString());
        System.out.println(jedis.llen(key));
        jedis.lrange(key, 0, -1)
                .stream().map(EventRecord::parse)
                .forEach(eventRecord -> {
                    System.out.println(eventRecord);
                });
        String count = "event-count";
        Long incr = jedis.incr(count);
        System.out.println(incr);
        String s = jedis.get(count);
        System.out.println(s);
        jedis.flushAll();
    }
}
