package com.mytest.local.queue;

/**
 * Created by hebo on 2016/5/3.
 */
public class Producer implements Runnable {

    private String instance;

    private BlockingQueueTest.Basket basket;

    public Producer(String instance, BlockingQueueTest.Basket basket) {
        this.instance = instance;
        this.basket = basket;
    }



    @Override
    public void run() {
        while (true){
            try {
                //生产苹果
                System.out.println("生产者准备生产苹果：" + instance);
                basket.produce();
                System.out.println("生产者准备生产苹果完毕：" + instance);
                //休眠300ms
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
