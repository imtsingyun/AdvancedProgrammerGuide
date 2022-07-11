package org.mindidea.netty.ch05.demo01;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class DiscardServer {

	private final int port;
	ServerBootstrap b = new ServerBootstrap();

	public DiscardServer(int port) {
		this.port = port;
	}

	public void runServer() {
		NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
		NioEventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			// 设置反应器轮询组
			b.group(bossGroup, workerGroup);
			// 设置通道类型
			b.channel(NioServerSocketChannel.class);
			// 设置监听端口号
			b.localAddress(port);
			b.option(ChannelOption.SO_BACKLOG, 128); // 设置线程队列得到连接个数
			// 设置通道参数
			b.childOption(ChannelOption.SO_KEEPALIVE, true);
			b.childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new DiscardHandler());
				}
			});
			ChannelFuture future = b.bind().sync();
			ChannelFuture closeFuture = future.channel().closeFuture();
			closeFuture.sync();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) {
		int port = 8089;
		new DiscardServer(port).runServer();
	}
}
