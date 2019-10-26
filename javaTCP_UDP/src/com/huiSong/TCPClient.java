package com.huiSong;

import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost",6666);
        byte[] bytes = new byte[1024];
        OutputStream ouputStream = socket.getOutputStream();
        ouputStream.write("客户端请求连接".getBytes());//对输出流写入信息

        ouputStream.close();
        socket.close();
    }
}
