package priv.lst.netty.client;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import java.util.Date;

/**
 * Created by lishutao on 2018/12/15.
 *
 * @author lishutao
 * @date 2018/12/15
 */
public class ClientHandler extends SimpleChannelHandler {
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
        throws Exception {
        String content = (String) e.getMessage();
        System.out.println(""+ new Date().toString() + "\n" + content);
    }

}
