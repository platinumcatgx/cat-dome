package com.TCP_IP;

import java.net.InetAddress;

public class sy01 {
    public static void main(String[] args) throws Exception{
        InetAddress localAddress = InetAddress.getLocalHost();
        InetAddress remoteAddress = InetAddress.getByName("www.itcast.cn");
        System.out.println("本地的IP地址："+localAddress.getHostAddress());
        System.out.println("itcast的IP地址："+remoteAddress.getHostAddress());
        System.out.println("3秒是否可达："+remoteAddress.isReachable(3000));
        System.out.println("itcast的主机名为："+remoteAddress.getHostName());
    }
}
