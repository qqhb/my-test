package com.mytest.local.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hebo on 2016/5/3.
 */
public class MyIoHandler extends IoHandlerAdapter{

    private final static Logger log = LoggerFactory.getLogger(MyIoHandler.class);

    @Override
    public void sessionOpened(IoSession session) throws Exception {
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String ip = session.getRemoteAddress().toString();
        System.out.println("==> Message From " + ip + ":" + message);
        //log.info();
    }
}
