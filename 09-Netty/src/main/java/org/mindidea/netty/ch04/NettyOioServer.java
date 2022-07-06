package org.mindidea.netty.ch04;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.util.CharsetUtil;

public class NettyOioServer {
	public void server(int port) throws Exception {
		final ByteBuf buf = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Hi!\r\n", CharsetUtil.UTF_8));
		OioEventLoopGroup group = new OioEventLoopGroup();
		try {
			
		} finally {
			group.shutdownGracefully().sync();
		}
	}
}
