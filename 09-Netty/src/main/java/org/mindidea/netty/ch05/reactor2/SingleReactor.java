package org.mindidea.netty.ch05.reactor2;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 单线程 Reactor 模式
 *
 * @author Wang
 * @version V1.0
 * Created on 2022-7-11 13:30
 */
public class SingleReactor {
	public static void main(String[] args) {

	}

	class Reactor implements Runnable {

		final Selector selector;

		public Reactor() throws IOException {
			this.selector = Selector.open();
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			// 设置为非阻塞模式
			serverSocketChannel.configureBlocking(false);

			// 把服务端的 channel 注册到 selector，注册 accept 事件
			SelectionKey selectionKey = serverSocketChannel.register(selector, 0);
			selectionKey.interestOps(SelectionKey.OP_ACCEPT);
			selectionKey.attach(new Acceptor(selectionKey));
		}

		private void dispatch(SelectionKey key) {
			Runnable r = (Runnable) key.attachment();

		}

		@Override
		public void run() {
			try {
				while (true) {
					int num = selector.select();
					if (num == 0) continue;
					Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
					while (iterator.hasNext()) {
						SelectionKey key = iterator.next();
						dispatch(key);
						iterator.remove();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class Acceptor implements Runnable {
		final SelectionKey k;
		final ServerSocketChannel sch;

		public Acceptor(SelectionKey key) throws IOException {
			k = key;
			sch = (ServerSocketChannel) key.channel();
		}

		@Override
		public void run() {
			try {
				SocketChannel socketChannel = sch.accept();
				socketChannel.configureBlocking(false);
				sch.register(k.selector(), SelectionKey.OP_READ);
				System.out.println("收到新连接：" + sch);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
