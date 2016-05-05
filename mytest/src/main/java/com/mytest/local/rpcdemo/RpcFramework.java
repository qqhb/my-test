package com.mytest.local.rpcdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ServerSocket;
import java.util.Date;

/**
 * Created by hebo on 2016/5/5.
 */
public class RpcFramework {
    private static Logger logger = LoggerFactory.getLogger(RpcFramework.class);

    public static void export(final Object service, int port) throws Exception{
        if(service == null){
            throw new IllegalArgumentException("service instance == null");
        }
        if(port < 0 || port > 65535){
            throw new IllegalArgumentException("Invalid port " + port);
        }

        logger.info("Export service " + service.getClass().getName() + " on port " + port);
        ServerSocket socket = new ServerSocket(port);
        Date date = new Date();

        java.sql.Date date1 = new java.sql.Date(date.getTime());

        for (;;){

        }





    }
}
