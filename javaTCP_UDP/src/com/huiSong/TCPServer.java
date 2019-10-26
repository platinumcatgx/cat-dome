package com.huiSong;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        System.out.println("服务端启动，等待连接。。。");
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            Socket socket = serverSocket.accept();
            byte[] bytes = new byte[1024];
            //通过socket获取输入流
            InputStream inputStream = socket.getInputStream();
            int len = inputStream.read(bytes);
            //打印获取到的文字
            System.out.println(new String(bytes,0,len));
            //获取输出流
            //OutputStream outputStream = socket.getOutputStream();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
