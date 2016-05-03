package com.mytest.local.extend;

/**
 * Created by hebo on 2016/4/28.
 */
public class STest extends FTest {

    public STest() {
        super();
        System.out.println("STest 子类输出");

    }


    public static void main(String[] args){

        STest sTest = new STest();
    }
}
