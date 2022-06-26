package org.mindidea.netty.ch01.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class NioClient01 {
	public static void main(String[] args) {
		try {
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);

			InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 19090);

			if (!socketChannel.connect(inetSocketAddress)) {
				while (!socketChannel.finishConnect()) {
					System.out.println("正在尝试连接...");
				}
			}

			String str = "hello, world!";
			ByteBuffer buffer = ByteBuffer.wrap(str.getBytes(StandardCharsets.UTF_8));
			socketChannel.write(buffer);
			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
