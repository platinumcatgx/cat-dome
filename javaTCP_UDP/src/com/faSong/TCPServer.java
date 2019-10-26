package com.faSong;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        try {
            //创建服务器套接字对象
            ServerSocket ss = new ServerSocket(8888);
            Socket socket = ss.accept();//监听端口
            //接受来自客户端的信息
            InputStream is = socket.getInputStream();
            byte[] b = new byte[1024];
            int len = is.read(b);
            System.out.println(new String(b,0,len));//输出接受到的文字

            OutputStream os = socket.getOutputStream();//获取输出流
            os.write("服务端收到连接请求，允许连接".getBytes());

            is.close();
            os.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
