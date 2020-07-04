package com.itheima02.upload;


import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 一个可以上传文件的服务器
 * */
public class ServerUpload1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7000);
        long name = System.currentTimeMillis();
        Socket accept = serverSocket.accept();
        // 创建输入流接收客户端数据
        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
        // 创建输出流将文件写入硬盘
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\MAO2\\Desktop\\copy\\java" + name + ".pdf");
        int len;  // 每次读入数据的长度
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }
        // 释放资源
        fileOutputStream.close();
        bis.close();
        // 关闭客户端
        accept.close();
    }
}
