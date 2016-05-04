package com.mytest.local.queue;

import java.util.concurrent.*;

/**
 * Created by hebo on 2016/5/3.
 */
public class ConcurrentLinkedQueueTest {
    private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();

    private static int count = 2;

    //同步辅助类,在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
    private static CountDownLatch latch = new CountDownLatch(count);

    public static void main(String[] args) throws Exception{
        long timeStart = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(4);
        ConcurrentLinkedQueueTest.offer();
        for (int i = 0; i < count; i++){
            service.submit(new Poll());
        }

        latch.await();
        System.out.println("cost time: " + (System.currentTimeMillis() - timeStart) + "ms");

    }

    /**
     * 生产
     */
    public static void offer(){
        for (int i = 0; i < 10000; i++){
            queue.offer(i);
        }
    }


    /**
     * 消费
     */
    static class Poll implements Runnable{

        @Override
        public void run() {
            while(!queue.isEmpty()){
                System.out.println(queue.poll());
            }
            latch.countDown();
        }
    }

}
