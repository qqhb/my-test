package com.mytest.local.mina;

/**
 * Created by hebo on 2016/5/3.
 */

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * 心跳服务
 */
public class ServerTest {

    private static final int PORT = 9123;

    //超时时间30s
    private static final int IDELTIMEOUT = 30;

    //心跳请求时间15s
    private static final int HEARTAEATRATE = 15;

    //心跳内容
    private static final String HEARTBEATREQUEST = "0x11";

    private static final String HEARTBEATRESPONSE = "0x12";

    private static final Logger log = LoggerFactory.getLogger(ServerTest.class);


    public static void main(String[] args) throws Exception{

        IoAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getSessionConfig().setReadBufferSize(1024);
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, IDELTIMEOUT);
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory()));
        KeepAliveMessageFactory heartBeatFactory = new KeepAliveMessageFactoryImpl();
        KeepAliveFilter heatBeat = new KeepAliveFilter(heartBeatFactory,IdleStatus.BOTH_IDLE);
        //设置是否forWord到下一个filter
        heatBeat.setForwardEvent(true);

        //设置心跳频率
        heatBeat.setRequestInterval(HEARTAEATRATE);

        acceptor.getFilterChain().addLast("heatbeat", heatBeat);

        acceptor.setHandler(new MyIoHandler());
        acceptor.bind(new InetSocketAddress(PORT));
        System.out.println("Server started on port: " + PORT);





    }


    private static class KeepAliveMessageFactoryImpl implements  KeepAliveMessageFactory{

        @Override
        public boolean isRequest(IoSession ioSession, Object o) {
            System.out.println("请求心跳信息是：" + o);
            //log.info("请求心跳信息是：" + o);
            if(o.equals(HEARTBEATREQUEST)){
                return true;
            }
            return false;
        }

        @Override
        public boolean isResponse(IoSession ioSession, Object o) {
            System.out.println("响应心跳信息是：" + o);
            //log.info("响应心跳信息是：" + o);
            if(o.equals(HEARTBEATRESPONSE)){
                return true;
            }
            return false;
        }

        @Override
        public Object getRequest(IoSession ioSession) {
            System.out.println("请求预设信息是：" + HEARTBEATREQUEST);
            //log.info("请求预设信息是：" + HEARTBEATREQUEST);
            return HEARTBEATREQUEST;
        }

        @Override
        public Object getResponse(IoSession ioSession, Object o) {
            System.out.println("请求预设信息是：" + HEARTBEATRESPONSE);
            //log.info("请求预设信息是：" + HEARTBEATRESPONSE);
            return HEARTBEATRESPONSE;
        }
    }

}
