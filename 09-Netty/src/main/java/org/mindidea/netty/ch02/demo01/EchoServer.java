package org.mindidea.netty.ch02.demo01;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class EchoServer {

	private final int port;

	public EchoServer(int port) {
		this.port = port;
	}

	private void start() throws InterruptedException {
		final EchoServerHandler serverHandler = new EchoServerHandler();
		NioEventLoopGroup boss = new NioEventLoopGroup();
		try {
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(boss)
					.channel(NioServerSocketChannel.class)
					.localAddress(new InetSocketAddress(port))
					// 添加 EchoServerHandler 到子 Channel 的 ChannelPipeline
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(serverHandler);
						}
					});
			// 异步地的绑定服务器，调用 sync 方法阻塞等待绑定完成
			ChannelFuture f = serverBootstrap.bind().sync();
			// 获取 Channel 的 CloseFuture，并且阻塞当前线程，直到完成
			f.channel().closeFuture().sync();
		} finally {
			boss.shutdownGracefully().sync();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new EchoServer(8089).start();
	}
}
