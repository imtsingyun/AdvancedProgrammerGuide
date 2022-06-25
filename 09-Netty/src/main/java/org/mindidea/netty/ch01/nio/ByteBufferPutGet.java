package org.mindidea.netty.ch01.nio;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ByteBufferPutGet {
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(64);

		buffer.putInt(100);
		buffer.putLong(99);
		buffer.putChar('王');
		buffer.putDouble(12.3);
		buffer.put("hello, world".getBytes(StandardCharsets.UTF_8));

		buffer.flip();

		System.out.println(buffer.getInt());
		System.out.println(buffer.getLong());
		System.out.println(buffer.getChar());
		System.out.println(buffer.getDouble());
	}
}
