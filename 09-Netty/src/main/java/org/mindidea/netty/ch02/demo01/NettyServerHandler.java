package org.mindidea.netty.ch02.demo01;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 自定义 handler
 *
 * @author Wang
 * @version V1.0
 * Created on 2022/7/3 22:37
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

	/**
	 * 读取客户端发送的数据
	 *
	 * @param ctx 上下文，含有管道pipeline，通道channel, 地址
	 * @param msg 客户端发送的数据
	 * @throws Exception ex
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("server ctx = " + ctx);

	}
}
