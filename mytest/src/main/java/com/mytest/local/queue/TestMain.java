package com.mytest.local.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hebo on 2016/5/3.
 */
public class TestMain {

    public static void main(String[] args){

        BlockingQueueTest queueTest = new BlockingQueueTest();
        BlockingQueueTest.Basket basket = queueTest.new Basket();

        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer1 = new Producer("生产者1",basket);
        Producer producer2 = new Producer("生产者2",basket);

        Consumer consumer = new Consumer(basket,"消费者1");
        Consumer consumer2 = new Consumer(basket,"消费者2");
        service.submit(producer1);
        service.submit(producer2);
        service.submit(consumer);
        service.submit(consumer2);


    }
}
