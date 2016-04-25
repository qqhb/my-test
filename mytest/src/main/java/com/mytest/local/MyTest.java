package com.mytest.local;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by hebo on 2016/4/6.
 */
public class MyTest {

    public static void main(String[] args){
        ReentrantLock reentrantLock = new ReentrantLock();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        String[] str = null;

        System.out.print(111);

        System.out.print("gitHub 修改");
    }
}
