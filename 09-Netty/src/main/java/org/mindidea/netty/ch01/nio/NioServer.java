package org.mindidea.netty.ch01.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class NioServer {

	public static void main(String[] args) throws IOException {
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

			Selector selector = Selector.open();
			serverSocketChannel.socket().bind(new InetSocketAddress(19090));
			serverSocketChannel.configureBlocking(false);

			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

			while (true) {
				// 没有事件发生
				if (selector.select(1000) == 0) {
					System.out.println("服务器等待了1秒，无连接");
					continue;
				}
				// 如果返回的大于0表示有事件发生, 获取相关的 selectionKey 集合
				Set<SelectionKey> selectionKeys = selector.selectedKeys();

				Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
				while (keyIterator.hasNext()) {
					SelectionKey key = keyIterator.next();
					// 客户端连接事件
					if (key.isAcceptable()) {
						SocketChannel socketChannel = serverSocketChannel.accept();
						socketChannel.configureBlocking(false);
						System.out.println("Client connect successful, socketChannel: " + socketChannel.hashCode());
						// 将 socketChannel 注册到 Selector, 关注事件为 OP_READ
						// 同时给 socketChannel 关联一个 Buffer
						socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
					}
					if (key.isReadable()) {
						// 通过 key 反向获取 channel
						SocketChannel socketChannel = (SocketChannel) key.channel();
						// 获取 chanel 关联的 buffer
						ByteBuffer buffer = (ByteBuffer) key.attachment();
						socketChannel.read(buffer);
						System.out.println("from client: " + new String(buffer.array(), StandardCharsets.UTF_8));
					}
					// 从集合中移动当前的 selectionKey, 防止重复操作
					keyIterator.remove();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
