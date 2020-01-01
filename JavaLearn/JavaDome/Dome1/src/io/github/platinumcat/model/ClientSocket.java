package io.github.platinumcat.model;//package io.github.platinumcat.model;
//
//import io.github.platinumcat.tool.ClientConnectServerThread;
//import io.github.platinumcat.tool.xxType;
//
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.Socket;
//
//public class ClientSocket{
//    private final String IP="192.168.31.14";
//    private final int PORT = 9527;
//    public Socket s ;
//
//    /**
//     * 向服务器发送消息对象：Object
//     * @param o 消息对象
//     * @return 是否发送成功
//     */
//    public boolean toServer(Object o){
//        boolean b = false;
//        try {
//            s=new Socket(IP,PORT);//连接
//            //发送数据
//            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
//            oos.writeObject(o);
//            //接受数据
//            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
//            XiaoXi xiaoXi = (XiaoXi) ois.readObject();
//
//            if (xiaoXi.getType() == xxType.message_common_message){
//                ClientConnectServerThread ccst = new ClientConnectServerThread(s);
//            }else
//                s.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return b;
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            return b;
//        }
//
//
//    }
//}
