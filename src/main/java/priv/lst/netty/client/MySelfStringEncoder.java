package priv.lst.netty.client;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.string.StringEncoder;

/**
 * Created by lishutao on 2019-08-19.
 *
 * @author lishutao
 * @date 2019-08-19
 */
public class MySelfStringEncoder extends StringEncoder {

    @Override
    protected Object encode(
        ChannelHandlerContext ctx, Channel channel, Object msg) throws Exception {
        Object object = super.encode(ctx, channel, msg);
        System.out.println("mySelfStringEncoder : ");

        return object;
    }
}
