package org.mindidea.netty.ch01.niochat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class GroupChatServer {

	private Selector selector;
	private ServerSocketChannel listenChannel;
	private static final int PORT = 19090;

	public GroupChatServer() {
		try {
			selector = Selector.open();
			listenChannel = ServerSocketChannel.open();
			listenChannel.socket().bind(new InetSocketAddress(PORT));
			listenChannel.configureBlocking(false);
			listenChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listen() {
		try {
			while (true) {
				int count = selector.select();
				if (count > 0) {
					Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
					while (iterator.hasNext()) {
						SelectionKey key = iterator.next();
						if (key.isAcceptable()) {
							SocketChannel sc = listenChannel.accept();
							sc.configureBlocking(false);
							sc.register(selector, SelectionKey.OP_READ);
							System.out.println(sc.getRemoteAddress() + " is online.");
						}
						if (key.isReadable()) {
							readMsg(key);
						}
						iterator.remove();
					}
				} else {
					System.out.println("waiting");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void readMsg(SelectionKey key) {
		SocketChannel channel = null;
		try {
			channel = (SocketChannel) key.channel();
			ByteBuffer allocate = ByteBuffer.allocate(1024);
			int count = channel.read(allocate);
			if (count > 0) {
				String msg = new String(allocate.array());
				System.out.println("from 客户端：" + msg);

				// 转发消息
				resendInfo(msg, channel);
			}
		} catch (Exception e) {
			try {
				assert channel != null;
				System.out.println(channel.getRemoteAddress() + " is offline...");
				key.cancel();
				channel.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	private void resendInfo(String msg, SocketChannel self) throws IOException {
		System.out.println("转发消息：");
		for (SelectionKey key : selector.keys()) {
			Channel channel = key.channel();
			if (channel instanceof SocketChannel && channel != self) {
				SocketChannel dest = (SocketChannel) channel;
				ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8));
				dest.write(buffer);
			}
		}
	}

	public static void main(String[] args) {
		GroupChatServer groupChatServer = new GroupChatServer();
		groupChatServer.listen();
	}
}
