package com.mytest.local.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by hebo on 2016/5/6.
 */
public class LinkedBlockingQueueTest {

    public static void main(String[] args) throws Exception{
        /**
         * add test 添加数据到队列中超出队列大小会报错
         */
        /*LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(3);
        linkedBlockingQueue.add("4");
        linkedBlockingQueue.add("1");
        linkedBlockingQueue.add("2");
        //linkedBlockingQueue.add("3");*/

        /**
         * put test 在添加到指定队列大小时候会发生阻塞
         */
        /*LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue(3);
        linkedBlockingQueue2.put("4");
        linkedBlockingQueue2.put("1");
        linkedBlockingQueue2.put("2");
        System.out.print("put 进去了3个......");
        linkedBlockingQueue2.put("3");
        System.out.print("put 弟4个，看看能不能put进去......");*/


        /**
         * offer 当添加到超出队列大小后会返回false,否则就是true
         */
        /*LinkedBlockingQueue linkedBlockingQueue3 = new LinkedBlockingQueue(3);
        boolean a = linkedBlockingQueue3.offer("4");
        boolean b = linkedBlockingQueue3.offer("1");
        boolean c = linkedBlockingQueue3.offer("2");
        boolean d = linkedBlockingQueue3.offer("3");
        System.out.println("a: " + a +" " + "b: " + b  + " c: " + c + " d: " + d);*/


        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);

    }
}
