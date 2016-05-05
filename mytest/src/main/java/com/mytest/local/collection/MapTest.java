package com.mytest.local.collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by hebo on 2016/5/4.
 */
public class MapTest {

    private static final Logger log = LoggerFactory.getLogger(MapTest.class);

    public static void main(String[] args){

        Map<String,String> map = new HashMap<>();
        map.put("a","1");
        map.put("b","1");
        map.put("v","1");
        map.put("d","1");
        map.put("c","1");
        map.put("e","1");
        map.put("f","1");


        Hashtable<String,String> hashtable = new Hashtable<String,String>();
        hashtable.put("a","1");
        hashtable.put("b","1");
        hashtable.put("v", "1");
        hashtable.put("d", "1");
        hashtable.put("c", "1");
        hashtable.put("e", "1");
        hashtable.put("f", "1");

        System.out.println("LinkedHashMap Test Start......");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(6,"6");
        linkedHashMap.put(7,"7");
        linkedHashMap.put(8,"8");
        linkedHashMap.put(9, "9");

        for (Iterator it = linkedHashMap.keySet().iterator(); it.hasNext();){
            Object key = it.next();
            System.out.println(key + " = " + linkedHashMap.get(key));
        }

        System.out.println("LinkedHashMap Test end......");

        System.out.println("hashMap Test Start......");
        Map<Integer,String> hashMap = new HashMap<>();
        hashMap.put(16,"16");
        hashMap.put(17,"17");
        hashMap.put(18,"18");
        hashMap.put(19, "19");
        for (Iterator it = hashMap.keySet().iterator(); it.hasNext();){
            Object key = it.next();
            System.out.println(key + " = " + hashMap.get(key));
        }
        System.out.println("hashMap Test end......");

        Map<String,String> map2 = Collections.synchronizedMap(new LinkedHashMap<String, String>());

    }
}
