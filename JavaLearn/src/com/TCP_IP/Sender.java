package com.TCP_IP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 发送端程序
 */
public class Sender {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(3000);
        String str = "hellow world";
        byte[] buf = str.getBytes();

        DatagramPacket dp = new DatagramPacket(buf , buf.length , InetAddress.getByName("locahost"),8520);

        System.out.println("发送信息");
        ds.send(dp);
        ds.close();
    }
}
