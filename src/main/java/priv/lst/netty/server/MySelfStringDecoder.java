package priv.lst.netty.server;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.string.StringDecoder;

/**
 * Created by lishutao on 2019-08-19.
 *
 * @author lishutao
 * @date 2019-08-19
 */
public class MySelfStringDecoder extends StringDecoder {

    @Override
    protected Object decode(
        ChannelHandlerContext ctx, Channel channel, Object msg) throws Exception {
        Object object = super.decode(ctx, channel, msg);
        System.out.println("mySelfStringDencoder : ");

        return object;
    }
}
