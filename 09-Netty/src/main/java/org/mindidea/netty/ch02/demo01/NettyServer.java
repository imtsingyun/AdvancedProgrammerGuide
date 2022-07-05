package org.mindidea.netty.ch02.demo01;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
	public static void main(String[] args) throws InterruptedException {
		// bossGroup 只处理连接请求
		NioEventLoopGroup bossGroup = new NioEventLoopGroup();
		// workerGroup 处理业务，两个 group 都是无限循环
		NioEventLoopGroup workerGroup = new NioEventLoopGroup();

		// 服务端启动对象
		ServerBootstrap bootstrap = new ServerBootstrap();
		// 配置启动对象参数
		bootstrap.group(bossGroup, workerGroup)        // 设置下个线程组
				.channel(NioServerSocketChannel.class) // 使用 NioServerSocketChannel 作为服务器通道实现
				.option(ChannelOption.SO_BACKLOG, 128) // 设置线程队列得到连接个数
				.childOption(ChannelOption.SO_KEEPALIVE, true) // 设置保持活动连接状态
				.childHandler(new ChannelInitializer<SocketChannel>() { // 创建通道测试对象
					// 给 pipeline 设置处理器
					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						ch.pipeline().addLast(null);
					}
				}); // 给我们的 workerGroup 的 EventLoop 对应的管道设置处理器
		System.out.println("server is ready...");
		//
		ChannelFuture cf = bootstrap.bind(8989).sync();

		cf.channel().closeFuture().sync();
	}
}
