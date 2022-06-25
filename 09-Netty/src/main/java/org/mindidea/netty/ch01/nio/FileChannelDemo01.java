package org.mindidea.netty.ch01.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class FileChannelDemo01 {
	public static void main(String[] args) throws IOException {
		String str = "hello, world";

		// 创建一个输出流，包装到 channel 中
		FileOutputStream fileOutputStream = new FileOutputStream("/Users/wangsuyu/file01.txt");

		// 通过 fileOutputString 获取对应的 FileChannel
		FileChannel fileChannel = fileOutputStream.getChannel();

		// 创建缓冲区
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

		// 将 str 放入 byteBuffer
		byteBuffer.put(str.getBytes(StandardCharsets.UTF_8));

		// 读数据之前先进行反转
		byteBuffer.flip();

		fileChannel.write(byteBuffer);
		fileOutputStream.close();;
	}
}
