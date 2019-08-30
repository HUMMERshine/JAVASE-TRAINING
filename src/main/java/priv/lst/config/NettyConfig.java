package priv.lst.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import priv.lst.netty.client.ClientHandler;
import priv.lst.netty.client.ClientThread;
import priv.lst.netty.client.NettyClient;
import priv.lst.netty.server.NettyServer;
import priv.lst.netty.server.ServerHandler;
import sun.security.krb5.internal.NetClient;

/**
 * Created by lishutao on 2018/12/15.
 *
 * @author lishutao
 * @date 2018/12/15
 */
@Configuration
public class NettyConfig {
    @Bean
    public ServerHandler serverHandler() {
        return new ServerHandler();
    }

    @Bean
    public NettyServer nettyServer(ServerHandler serverHandler) {
        NettyServer nettyServer = new NettyServer();
        nettyServer.setHandler(serverHandler);
        nettyServer.setPort(8088);
        return nettyServer;
    }
    //跟下边的方法一样
//    @Bean
//    public NettyServer nettyServer() {
//        NettyServer nettyServer = new NettyServer();
//        nettyServer.setHandler(serverHandler());
//        nettyServer.setPort(8080);
//    }

    @Bean
    public ClientHandler clientHandler() {
        return new ClientHandler();
    }

    @Bean
    public NettyClient nettyClient() {
        NettyClient nettyClient = new NettyClient();
        nettyClient.setHost("127.0.0.1");
        nettyClient.setPort(8088);
        nettyClient.setHandler(clientHandler());
        return nettyClient;
    }

    @Bean
    public ClientThread clientThread () {
        ClientThread clientThread = new ClientThread();
        clientThread.setNettyClient(nettyClient());
        return clientThread;
    }
}
