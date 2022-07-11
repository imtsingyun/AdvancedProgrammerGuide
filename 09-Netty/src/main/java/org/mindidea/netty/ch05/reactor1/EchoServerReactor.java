package org.mindidea.netty.ch05.reactor1;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class EchoServerReactor implements Runnable {

	Selector selector;
	ServerSocketChannel ssc;

	public EchoServerReactor() throws IOException {
		selector = Selector.open();
		ssc = ServerSocketChannel.open();
		ssc.configureBlocking(false);
		SelectionKey register = ssc.register(selector, 0);
	}

	@Override
	public void run() {

	}
}
