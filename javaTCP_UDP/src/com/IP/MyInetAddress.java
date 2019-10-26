package com.IP;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyInetAddress {
    public static void main(String[] args) {
        InetAddress ia ;
        try {
            ia = InetAddress.getLocalHost();
            String localIP=ia.getHostAddress();
            String localName = ia.getHostName();
            System.out.println("本机IP："+localIP+"本机名称："+localName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
