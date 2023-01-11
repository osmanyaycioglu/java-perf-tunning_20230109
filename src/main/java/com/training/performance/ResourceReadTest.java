package com.training.performance;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResourceReadTest {

    private static ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024*1024*5);

    public static void main(String[] args) throws Exception {
        File file = new File("customer.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        FileChannel channel = fileInputStream.getChannel();
        channel.read(byteBuffer);
        int limit = byteBuffer.limit();

        int read = fileInputStream.read();
        byte[] bytes = new byte[1024*1024*20];
        int read1 = fileInputStream.read(bytes);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        // byte[] bytes1 = bufferedInputStream.readAllBytes();

        byte[] bytes2 = Files.readAllBytes(Paths.get("customer.txt"));

        Socket socket = null;
        SocketChannel channel1 = socket.getChannel();
        byteBuffer.reset();
        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());
        channel1.read(byteBuffer);
        long aLong = byteBuffer.getLong();
    }

}
