/*
 * 聊天的界面
 */
package com.qq.client.view;

import javax.activation.MailcapCommandMap;
import javax.swing.*;

import com.qq.client.model.*;
import com.qq.client.tools.ManageClientConServerThread;
import com.qq.common.Message;
import com.qq.common.MessageType;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QQChat extends JFrame implements ActionListener{

	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	String ownerId, friend,sencry;

	//测试代码
	public static void main(String[] args) {
		QQChat qq = new QQChat("1","1");

	}
	/**
	 * QQ聊天的构造方法
	 * @param ownerId 所有者
	 * @param friend 朋友
	 */
	public QQChat(String ownerId, String friend){
		this.ownerId = ownerId;
		this.friend = friend;
		jta = new JTextArea();//多行文本框
		jtf = new JTextField(25);//单行文本框
		jb = new JButton("发送");
		jb.addActionListener(this);//添加动作监听器
		jp = new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jta,"Center");
		this.add(jp,"South");
		this.setTitle(ownerId+"正在和"+friend+"聊天");
		this.setIconImage((new ImageIcon("企鹅.jpg").getImage()));
		this.setSize(400,400);
		this.setVisible(true);
		
		//启动服务
		
		
	}
	
	//显示消息
	public void showMessage(Message ms){
		String msg = ms.getSender()+">>>"+ms.getGetter()+":=:>"+ms.getCon();
		System.out.println("读取从服务器发来的消息："+msg);
		//解密
		QQEncryption qqe = new QQEncryption();
		String plaintext= qqe.DESDecryption(ms.getCon());
		
		String info = ms.getSender()+"对"+ms.getGetter()+"说:"+plaintext+"\r\n";
		QQChat.toFile("file/chat/",info,ms.getSender(),ms.getGetter());//写入文件
		//从文件中获取聊天内容
//		ArrayList al = null;
//		al = (ArrayList) QQChat.readMsg("file/chat/","chatFile.cf"," "," ");
//		System.out.println(al.toString());


		this.jta.append(info);
	}

	/**
	 * 将文件写入到本地
	 * @param LuJing 文件路径
	 * @param data 内容
	 */
	public static void toFile(String LuJing,String data,String fs ,String js){
		//将聊天记录写入本地文件
		File file = null;
		FileOutputStream fos = null;
		try {
			file = new File(LuJing+fs+"to"+js+"chatFile.cf");
			fos = new FileOutputStream(file,true);
			String str = data+"\n";
			fos.write(data.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

//	public static List readMsg(String LuJing , String fileName , String fs , String js){
//		FileReader fr = null;
//		ArrayList<String> s = new ArrayList<>();
//		char[] c = new char[200];
//		try {
//			fr = new FileReader(new File(LuJing+fileName));
//			for (int i = 0; i < 10; i++) {
//				fr.read(c);
//				System.out.println(c.toString());
//				s.add(c.toString());
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return s;
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jb){
			//点击了发送按钮
			
			
			//进行加密操作
			QQEncryption qqe = new QQEncryption();
			sencry = qqe.DESEncryption(jtf.getText());
			
			Message ms = new Message();
			ms.setMesType(MessageType.message_common_message);
			ms.setSender(this.ownerId);
			ms.setGetter(this.friend);
			ms.setCon(sencry);
			ms.setSendTime(new java.util.Date().toString());//传入当前时间

			jta.append(ms.getCon());
			
			jtf.setText("");//处理发送数据后的框,使其为空。
			//发送，要拿到socket
			try {
				ObjectOutputStream oos = new ObjectOutputStream(ManageClientConServerThread.getManageClientThread(this.ownerId).getS().getOutputStream());
				oos.writeObject(ms);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	
	
//	public void run() {
//		// TODO Auto-generated method stub
//		//开始读取
//		while(true){
//			try {
//				ObjectInputStream  ois = new ObjectInputStream(MyqqclientConnectServer.s.getInputStream());
//				Message ms = (Message)ois.readObject();
//				
//				//显示
//				String info = ms.getSender()+"对"+ms.getGetter()+"说:"+ms.getCon()+"\r\n";
//				this.jta.append(info);			
//				
//				
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//			
//			
//		}
//	}

}
