package org.mindidea.netty.ch01.nio;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * MappedByteBuffer 可以在堆外内存中直接修改，操作系统不需要拷贝一次
 *
 * @author Wang
 * @version V1.0
 * Created on 2022/6/24 18:12
 */
public class MappedByteBuffer {
	public static void main(String[] args) throws IOException {
		RandomAccessFile rw = new RandomAccessFile("/Users/wangsuyu/1.txt", "rw");
		FileChannel channel = rw.getChannel();

		java.nio.MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
		map.put(0, (byte) 'H');
		map.put(3, (byte) '9');

		rw.close();
	}
}
