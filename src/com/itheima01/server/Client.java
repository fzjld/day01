package com.itheima01.server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.6", 7000);
        // 创建输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Man Utd is champion".getBytes());
        outputStream.close();
    }
}
