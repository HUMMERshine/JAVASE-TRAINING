package priv.lst.netty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import priv.lst.netty.client.ClientThread;
import priv.lst.netty.client.NettyClient;
import priv.lst.netty.server.NettyServer;

/**
 * Created by lishutao on 2018/12/15.
 *
 * @author lishutao
 * @date 2018/12/15
 */
@Component
public class NettyTest {

    @Autowired
    NettyServer nettyServer;

    @Autowired
    ClientThread clientThread;

    public void init() {
        nettyServer.init();
        nettyServer.start();

        clientThread.init();
    }

    public void sendMsg(String msg) {
        clientThread.sendMessage(msg);
    }

}
