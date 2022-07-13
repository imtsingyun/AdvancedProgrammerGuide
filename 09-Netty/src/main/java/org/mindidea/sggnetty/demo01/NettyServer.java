package org.mindidea.sggnetty.demo01;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

@SuppressWarnings("DuplicatedCode")
public class NettyServer {
	public static void main(String[] args) throws InterruptedException {

		// bossGroup 处理连接请求
		// 真正的客户端业务处理交给 workerGroup 处理
		// 两个都是无限循环
		NioEventLoopGroup bossGroup = new NioEventLoopGroup();
		NioEventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			// 创建服务器端的启动对象，配置参数
			ServerBootstrap bootstrap = new ServerBootstrap();

			// 使用链式编程进行设置
			bootstrap.group(bossGroup, workerGroup)    // 设置两个线程组
					.channel(NioServerSocketChannel.class) // 使用 nioServerSocketChannel 作为服务器的通道实现
					.option(ChannelOption.SO_BACKLOG, 128) // 设置线程队列得到连接个数
					.childOption(ChannelOption.SO_KEEPALIVE, true) // 设置保持活动连接状态
					.childHandler(new ChannelInitializer<SocketChannel>() { // 创建一个通道初始化对象
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							// 给 pipeline 设置处理器
							ch.pipeline().addLast(new NettyServerHandler());
						}
					});

			System.out.println("...server is ready...");
			// 绑定端口并同步
			ChannelFuture future = bootstrap.bind(6688).sync();

			// 监听通道关闭（异步模型）
			future.channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}
