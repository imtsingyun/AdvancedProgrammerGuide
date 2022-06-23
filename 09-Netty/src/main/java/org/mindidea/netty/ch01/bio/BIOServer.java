/*
 * @class BIOServer
 * @package org.mindidea.netty.ch01.bio
 * Created on 2022/6/20 15:45
 */
package org.mindidea.netty.ch01.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池实现 BIO
 *
 * @author Wang
 * @version V1.0
 * Created on 2022/6/20 12:44
 */
public class BIOServer {

	public static void main(String[] args) throws IOException {
		ExecutorService newCachedThreadPool = Executors.newFixedThreadPool(2);

		ServerSocket serverSocket = new ServerSocket(8000);
		System.out.println("服务器启动成功");

		while (true) {
			Socket socket = serverSocket.accept();
			System.out.println("已连接一个客户端");

			newCachedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("ThreadName: " + Thread.currentThread().getName());
					handler(socket);
				}
			});
		}
	}

	public static void handler(Socket socket) {
		try {
			byte[] bytes = new byte[1024];
			InputStream inputStream = socket.getInputStream();
			while (true) {
				int read = inputStream.read(bytes);
				if (read != -1) {
					System.out.println(new String(bytes, 0, read));
				} else {
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			System.out.println("关闭与客户端的连接");
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
