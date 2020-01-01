/*
 * 这个线程负责客户端与服务器的通讯，每开启一个聊天就新建一个Thread
 */
package com.qq.client.tools;

import java.net.*;
import java.io.*;

import com.qq.client.model.QQEncryption;
import com.qq.client.view.QQChat;
import com.qq.client.view.QQFriendList;
import com.qq.common.Message;
import com.qq.common.MessageType;


public class ClientConnectServerThread extends Thread{
	private Socket s;
	
	public Socket getS() {
		return s;
	}
	
	public ClientConnectServerThread(Socket s){
		this.s = s;
		
	}
	
	public void run(){
		while(true){
			//不停地读取数据
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Message ms = (Message)ois.readObject();
				
				if(ms.getMesType().equals(MessageType.message_common_message)){//如果是普通数据包
					
					//把从服务器获得的消息显示到对应的聊天对话框
					QQChat qqchat = ManageQQChat.getManageQQChat(ms.getGetter()+" "+ms.getSender());
					qqchat.showMessage(ms);//调用QQ聊天的显示消息的方法
				}else if(ms.getMesType().equals(MessageType.message_receive_OnlineFriend)){//类型为返回在线好友
					//获得在线好友
					String con = ms.getCon();//获得消息本身
					String Friends[] = con.split(" ");//用空格分割消息，获得好友列表
					String getter = ms.getGetter();
					
					//获得对应的好友列表并更新
					QQFriendList qqfriendList = ManageQQFriendList.getManageQQFriendList(getter);
					
					if(qqfriendList != null){
						qqfriendList.UpdateFriend(ms);		
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
