package com.mytest.local.queue;

/**
 * Created by hebo on 2016/5/3.
 */
public class Consumer implements Runnable {
    private String instance;

    private BlockingQueueTest.Basket basket;

    public Consumer(BlockingQueueTest.Basket basket, String instance) {
        this.basket = basket;
        this.instance = instance;
    }

    @Override
    public void run() {
        while (true){
            try {
                //消费苹果
                System.out.println("消费者准备消费苹果：" + instance);
                basket.consume();
                System.out.println("消费者准备消费苹果完毕：" + instance);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
