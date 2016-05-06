package com.mytest.local.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hebo on 2016/5/4.
 */
public class ListTest {



    public static void main(String[] args){
        List list = new ArrayList();
        LinkedList list1 = new LinkedList();
        double numa = 5.12;

       // addNumber(5);


    }

    public static int addNumber(int num){
        if(num ==0){
            return 11;
        }else{
            num--;
            int a = addNumber(num);
            System.out.println("num " + num);
            System.out.println("a " + a);
        }
        return -1;
    }
}
