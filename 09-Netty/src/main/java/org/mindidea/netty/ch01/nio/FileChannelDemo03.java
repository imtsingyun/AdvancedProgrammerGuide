package org.mindidea.netty.ch01.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通过 FileChannel 拷贝文件
 *
 * @author Wang
 * @version V1.0
 * Created on 2022/6/24 15:10
 */
public class FileChannelDemo03 {
	public static void main(String[] args) throws IOException {
		FileInputStream fileInputStream = new FileInputStream("/Users/wangsuyu/1.txt");
		FileChannel fileInputChannel = fileInputStream.getChannel();

		FileOutputStream fileOutputStream = new FileOutputStream("/Users/wangsuyu/2.txt");
		FileChannel fileOutputChannel = fileOutputStream.getChannel();

		ByteBuffer byteBuffer = ByteBuffer.allocate(512);

		while (true) {
			byteBuffer.clear();
			int read = fileInputChannel.read(byteBuffer);
			if (read == -1) {
				break;
			}
			// 将 buffer 中的数据写入到 fileOutputChannel
			byteBuffer.flip();
			fileOutputChannel.write(byteBuffer);
		}
		fileInputStream.close();
		fileOutputStream.close();
	}
}
