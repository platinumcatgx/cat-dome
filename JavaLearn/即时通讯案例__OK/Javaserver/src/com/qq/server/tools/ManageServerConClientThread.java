package com.qq.server.tools;

import java.util.HashMap;
import java.util.Iterator;
/*
 * 管理客户端的Socket
 */
public class ManageServerConClientThread {
	
	public static HashMap hm = new HashMap<String, ServerConnectClientThread>();//做成静态的

	/**
s	 * @param uid 用户ID
	 * @param sct 服务端与客户端连接
	 */
	public static void addClientThread(String uid , ServerConnectClientThread sct){
		hm.put(uid, sct);
	}

	/**
	 * 通过用户ID获取连接
	 * @param uid
	 * @return
	 */
	public static ServerConnectClientThread getClientThread(String uid){
		return (ServerConnectClientThread)hm.get(uid);
	}

	/**
	 * 根据ID从集合中删除聊天线程
	 * @param userIDtr
	 */
	public static void remove(String userIDtr){
		hm.remove(userIDtr);
	}

	/**
	 * 返回在线好友的情况
	 * @return
	 */
	public static String GetOnlineUserId(){
		String res = "";
		//使用迭代器，通过空格分离在线好友
		Iterator it = hm.keySet().iterator();
		while(it.hasNext()){
			//便利时判断对应的线程是否存活，如果不存活则删除该键值对--<尚未实现>--解决客户端端主动断开连接后服务端为变化问题
			res +=it.next().toString()+" ";
		}
		return res;
		
	}
}
