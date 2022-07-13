package org.mindidea.sggnetty.demo01;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * 自定义 handler, 需要继承 HandlerAdapter
 *
 * @author Wang
 * @version V1.0
 * Created on 2022/7/13 23:11
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

	/**
	 * 读取数据消息
	 *
	 * @param ctx 上下文对象，含有 pipeline, channel, 地址等
	 * @param msg 客户端发送的消息
	 * @throws Exception ex
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("server ctc = " + ctx);
		// 将 msg 转 ByteBuf (netty 提供的)
		ByteBuf buf = (ByteBuf) msg;
		System.out.println("客户端的消息：" + buf.toString(CharsetUtil.UTF_8));
		System.out.println("客户端地址：" + ctx.channel().remoteAddress());
	}

	/**
	 * 数据读取完毕
	 *
	 * @param ctx 上下文
	 * @throws Exception ex
	 */
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// 将数据写入缓存区，并刷新
		ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端～", CharsetUtil.UTF_8));
	}

	/**
	 * 发生异常时
	 *
	 * @param ctx   上下文
	 * @param cause 异常信息
	 * @throws Exception ex
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// 发生异常时关闭连接
		ctx.close();
	}
}
