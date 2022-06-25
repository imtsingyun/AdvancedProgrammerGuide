package org.mindidea.netty.ch01.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 拷贝文件 transferFrom
 *
 * @author Wang
 * @version V1.0
 * Created on 2022/6/24 17:29
 */
public class FileChannelDemo04 {

	public static void main(String[] args) throws IOException {
		FileInputStream fileInputStream = new FileInputStream("/Users/wangsuyu/a.jpg");
		FileOutputStream fileOutputStream = new FileOutputStream("/Users/wangsuyu/b.jpg");

		FileChannel sourChn = fileInputStream.getChannel();
		FileChannel destChn = fileOutputStream.getChannel();

		destChn.transferFrom(sourChn, 0, sourChn.size());

		sourChn.close();
		destChn.close();
		fileInputStream.close();
		fileOutputStream.close();
	}
}
