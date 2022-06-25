package org.mindidea.netty.ch01.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo99 {
	public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println(readByChannel().length());
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
    }

    private static String readByChannel() throws IOException {
        long counts = 0;
        File file = new File("/Users/wangsuyu/AMM.SGM");
        FileInputStream fis = new FileInputStream(file);
        FileChannel fileChannel = fis.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(8048);
        int offset;
        StringBuilder sb = new StringBuilder();
        while((offset = fileChannel.read(byteBuffer)) != -1) {
            counts = counts + offset;
            sb.append(new String(byteBuffer.array()));
            byteBuffer.clear();
        }
        fileChannel.close();
        fis.close();
        return sb.toString();
    }
}
