package com.qq.server.model;

import java.net.*;
import java.io.*;
import com.qq.common.*;
import com.qq.server.tools.ManageServerConClientThread;
import com.qq.server.tools.ServerConnectClientThread;
import com.qq.server.db.DBSUID;

/**
 * qq服务器，监听等待客户端的连接
 */
public class MyQQServer implements java.io.Serializable{

	public MyQQServer(){
		try {
			//启动服务器并监听
			System.out.println("我是服务器,我在8080监听");
			ServerSocket sc = new ServerSocket(8080);
			while(true){
				//阻塞等待连接
				Socket s = sc.accept();

				//接收数据
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				User u = (User)ois.readObject();//拿到U后去数据库验证,根据验证的结果返回不同的messagetype

				Message ms = new Message();

				//将验证完后的信息返回
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

				switch (u.getIfNew()) {
					case 1://表示来注册的
						//判断QQ号码是否已经存在
		 				if(DBSUID.zhuCe(u.getUserId(),u.getPasswd())){
		 					//qq号码已经注册成功
		 					ms.setMesType("6");
							oos.writeObject(ms);
							s.close();
						}else{
							//qq号码注册失败
							ms.setMesType("7");
							oos.writeObject(ms);
							//关闭连接
							s.close();
						}
						break;
					case 2: //表示来登陆的
						//判断QQ密码是否正确
		 				if(DBSUID.dengLu(u.getUserId(),u.getPasswd())){//先简单来吧 简单的规则是：如果密码是123456就认为成功
							ms.setMesType("1");
							oos.writeObject(ms);

							//成功登录后，服务器为客户端单开一个线程来负责该客户端的通讯
							ServerConnectClientThread scct = new ServerConnectClientThread(s);

							//将新开的线程加入到 hashmap
							ManageServerConClientThread.addClientThread(u.getUserId(), scct);

							//启动通讯线程
							scct.start();

							//并通知其他在线用户说我上线了
							scct.NoticeOther(u.getUserId());
						}else{
							ms.setMesType("2");
							oos.writeObject(ms);
							//密码错误，关闭连接
							s.close();
						}
		 				break;
					case 11:
						break;
					case 12:
						break;
					default:
						break;
				}


			}

		} catch (Exception e) {
			e.printStackTrace();//打印出异常
		}
	}


	
}
