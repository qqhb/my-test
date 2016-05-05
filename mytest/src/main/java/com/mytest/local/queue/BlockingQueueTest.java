package com.mytest.local.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by hebo on 2016/5/3.
 */
public class BlockingQueueTest {

    public class Basket{
        //定义队列大小(篮子,能够容纳3个苹果)
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(3);

        BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(2);

        BlockingQueue<String> arrayBlockingQueue2 = new LinkedBlockingQueue<String>(3);

        /**
         * 生产苹果,放入篮子
         */
        public void produce() throws InterruptedException{
        //用put放入一个拼过,若blockingQueue满了，等到blockingQueue有位置
            blockingQueue.put("An apple");
        }

        /**
         * 消费者,从篮子中取走
         * @return
         * @throws InterruptedException
         */
        public String consume() throws InterruptedException{
            //若take方法取出一个苹果,若blockingQueue为空，等到blockingQueue有苹果位置(获取并移除此队列的头部)
            return blockingQueue.take();
        }
    }
}
