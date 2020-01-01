/*
 * 这是客户端连接服务器的后台
 */
package com.qq.client.model;
import java.net.*;
import java.io.*;
import java.net.*;

import com.qq.client.tools.ClientConnectServerThread;
import com.qq.client.tools.ManageClientConServerThread;
import com.qq.common.*;

public class MyQQClient implements java.io.Serializable{

	public Socket s;
	
	//发送第一次请求
	public boolean sendLoginInfoToServer(Object o){
		boolean b = false;
		try {
			s = new Socket("127.0.0.1",8080);

			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);

			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());

			System.out.println(ois.readObject());
//			Message ms = (Message)ois.readObject();

//			if(ms.getMesType().equals("1")){
//				//验证成功
//
//				//创建该id和服务器的保持通讯连接的thread，保存到hashmap中，并启动
//				ClientConnectServerThread ccst = new ClientConnectServerThread(s);
//				ccst.start();
//				ManageClientConServerThread.addManageClientThread(((User)o).getUserId(), ccst);
//				b = true;
//
//			}else{
//				s.close();
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return b;
	}
	
	//后面的发送，都是数据的发送
	public void SendInfoToServer(Object o){
		
	}
	
	/*
	 * 检查QQ号是否应经存在,已存在返回false，否则返回true
	 */
	public boolean SendQQnumberToServer(User u){
		boolean b = false;
		try {
			s = new Socket("127.0.0.1",8080);			
			//发送数据
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(u);
			
			//接收数据
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			Message ms = (Message)ois.readObject();
			
			if(ms.getMesType().equals("7")){
				//注册失败
				b = false;			
			}else if(ms.getMesType().equals("6")){
				//注册成功
				b = true;
			}else{
				s.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO Auto-generated catch block
			try {
				s.close();//我的意思是注册完就结束掉链接，然后开启登录界面开始新的连接。
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b;
	}

}
