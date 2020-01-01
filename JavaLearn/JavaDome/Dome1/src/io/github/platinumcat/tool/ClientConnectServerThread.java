package io.github.platinumcat.tool;//package io.github.platinumcat.tool;
//
//import io.github.platinumcat.GUI.Chat;
//import io.github.platinumcat.GUI.FriendList;
//import io.github.platinumcat.model.XiaoXi;
//
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.net.Socket;
//
///**
// * 这个线程负责客户端与服务器的通讯，每开启一个聊天就新建一个Thread
// */
//public class ClientConnectServerThread implements Runnable {
//    private Socket s;
//
//    public Socket getS() {
//        return s;
//    }
//
//    public void setS(Socket s) {
//        this.s = s;
//    }
//
//    @Override
//    public void run() {
//        s=new
//        //循环读取数据
//        while (true){
//            try {
//                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
//                XiaoXi xiaoXi = (XiaoXi)ois.readObject();
//                if (xiaoXi.getType()==xxType.message_common_message){
//                    //把从服务器获得的消息显示到对应的聊天对话框
//                    Chat chat = ManageChat.getManageQQChat(xiaoXi.getJs()+" "+xiaoXi.getFs());
//                    chat.showXiaoXi();//调用QQ聊天的显示消息的方法
//                }else if(xiaoXi.getType()==xxType.message_receive_OnlineFriend){
//                    //获得在线好友
//                    String con = xiaoXi.getData();//获得消息本身
//                    String Friends[] = con.split(" ");//用空格分割消息，获得好友列表
//                    String getter = xiaoXi.getJs();
//                    //获得对应的好友列表并更新
//                    FriendList friendList = ManageFriendList.getManageQQFriendList(getter);
//                    if(friendList != null){
//                        friendList.UpdateFriend(xiaoXi);
//                    }
//                }else{
//
//                }
//            }catch (IOException e){
//                e.printStackTrace();
//            }catch (ClassNotFoundException e){
//                e.printStackTrace();
//            }
//
//        }
//    }
//}
