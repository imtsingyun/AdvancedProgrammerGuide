package org.mindidea.netty.ch01.nio;

import java.nio.IntBuffer;

/**
 * 演示 Buffer 的使用
 *
 * @author Wang
 * @version V1.0
 * Created on 2022/6/23 22:05
 */
public class BasicBuffer {
	public static void main(String[] args) {
		// 创建一个 Buffer, 可以存放 5 个 int
		IntBuffer intBuffer = IntBuffer.allocate(5);

		// 向 Buffer 中存入数据
		for (int i = 0; i < intBuffer.capacity(); i++) {
			intBuffer.put(i * 10);
		}

		// 先进行读写切换，才能再从 buffer 中读数据
		intBuffer.flip();

		// 从 buffer 中读数据
		while (intBuffer.hasRemaining()) {
			System.out.println(intBuffer.get());
		}
	}
}
