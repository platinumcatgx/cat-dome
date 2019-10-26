package com.faSong;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception{
            Socket socket = new Socket("localhost",8888);
            //向服务器传送数据
            OutputStream os = socket.getOutputStream();
            os.write("客户端请求连接服务器".getBytes());
            //接受服务器回送的数据
            InputStream is = socket.getInputStream();
            byte[] b = new byte[1024];
            int len = is.read(b);
            System.out.println(new String(b,0,len));

            is.close();
            os.close();
            socket.close();
    }
}
