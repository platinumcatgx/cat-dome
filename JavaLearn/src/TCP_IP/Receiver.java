package TCP_IP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver {
    public static void main(String[] args) throws Exception {
        byte[] buf = new byte[1024];//接受数据用的字节数组
        DatagramSocket ds = new DatagramSocket(8520);//定义一个datagramSocket对象，监听端口为8954
        DatagramPacket dp = new DatagramPacket(buf , buf.length);

        System.out.println("等待接收数据");
        ds.receive(dp);//等待接受数据，如果没有数据会阻塞

        String str = new String(dp.getData(),0,dp.getLength())+"from"+dp.getAddress().getHostAddress()+":"+dp.getPort();
        System.out.println(str);//打印接受到的消息
        ds.close();
    }



}
