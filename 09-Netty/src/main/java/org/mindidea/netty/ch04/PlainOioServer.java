package org.mindidea.netty.ch04;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class PlainOioServer {
	public void server(int port) throws IOException {
		// 将服务器绑定到指定端口
		final ServerSocket socket = new ServerSocket(port);
		try {
			for (;;) {
				// 接受连接
				final Socket clientSocket = socket.accept();
				System.out.println("Accepted connection from " + clientSocket);
				// 创建一个新的线程来处理该连接
				new Thread(() -> {
					OutputStream out;
					try {
						out = clientSocket.getOutputStream();
						out.write("Hi\r\n".getBytes(StandardCharsets.UTF_8));
						out.flush();
						clientSocket.close();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							clientSocket.close();
						} catch (IOException ex) {
							// ignore on close
						}
					}
				}).start();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
