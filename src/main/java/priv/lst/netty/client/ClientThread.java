package priv.lst.netty.client;

import org.jboss.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Created by lishutao on 2018/12/15.
 *
 * @author lishutao
 * @date 2018/12/15
 */
@Component
public class ClientThread {
    private NettyClient nettyClient;

    private Scanner scanner = new Scanner(System.in);

    public void init() {
        nettyClient.init();
        nettyClient.start();
    }

    public void sendMessage(String msg) {
        Channel channel = nettyClient.getChannelFuture().getChannel();
        System.out.println("发送消息（Enter发送）:");
        if(msg.toString().equals("quit")) {
            System.out.println("wait, you will quit..");
            nettyClient.stop();

        }
        channel.write(msg);
    }

    public void setNettyClient(NettyClient nettyClient) {
        this.nettyClient = nettyClient;
    }

}
