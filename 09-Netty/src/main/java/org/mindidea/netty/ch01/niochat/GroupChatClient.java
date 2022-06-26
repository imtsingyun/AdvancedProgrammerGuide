package org.mindidea.netty.ch01.niochat;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class GroupChatClient {
	private final String HOST = "127.0.0.1";
	private final int PORT = 19090;
	private Selector selector;
	private SocketChannel socketChannel;
	private String username;

	public GroupChatClient() {
		try {
			selector = Selector.open();

			InetSocketAddress inetSocketAddress = new InetSocketAddress(HOST, PORT);
			socketChannel = SocketChannel.open(inetSocketAddress);
			socketChannel.configureBlocking(false);
			socketChannel.register(selector, SelectionKey.OP_READ);
			username = socketChannel.getLocalAddress().toString().substring(1);
			System.out.println(username + " is ok...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendInfo(String info) {
		info = username + "-说: " + info;
		try {
			socketChannel.write(ByteBuffer.wrap(info.getBytes(StandardCharsets.UTF_8)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void readInfo() {
		try {
			int readChannels = selector.select();
			if (readChannels > 0) {
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectionKeys.iterator();
				while (iterator.hasNext()) {
					SelectionKey key = iterator.next();
					if (key.isReadable()) {
						SocketChannel sc = (SocketChannel) key.channel();
						ByteBuffer buff = ByteBuffer.allocate(1024);
						sc.read(buff);
						String msg = new String(buff.array());
						System.out.println(msg.trim());
					}
					iterator.remove();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		GroupChatClient client = new GroupChatClient();
		new Thread(() -> {
			while (true) {
				client.readInfo();
				try {
					try {
						TimeUnit.SECONDS.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String str = scanner.nextLine();
			client.sendInfo(str);
		}
	}
}
