package org.mindidea.sggnetty.demo01;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {

	/**
	 * 通道就绪时触发该方法
	 *
	 * @param ctx 上下文
	 * @throws Exception ex
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("client ctx = " + ctx);
		ctx.writeAndFlush(Unpooled.copiedBuffer("hello, server...", CharsetUtil.UTF_8));
	}

	/**
	 * 当通道有读取事件时触发
	 *
	 * @param ctx 上下文
	 * @param msg 消息
	 * @throws Exception ex
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf) msg;
		System.out.println("服务器回复的消息：" + buf.toString(CharsetUtil.UTF_8));
		System.out.println("服务器的地址：" + ctx.channel().remoteAddress());
	}
}
