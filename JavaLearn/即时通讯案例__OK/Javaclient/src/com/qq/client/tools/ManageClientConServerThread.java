/*
 * 管理  ClientConnectServerThread 的类
 */
package com.qq.client.tools;

import java.util.*;

public class ManageClientConServerThread {
	
	private static HashMap hs = new HashMap<String, ClientConnectServerThread>();
	
	//把创建好的ClientConnectServerThread放入到hashMap中
	public static void addManageClientThread(String id, ClientConnectServerThread ccst){
		hs.put(id, ccst);
	}
	//可以通过id获取对应线程
	public static ClientConnectServerThread getManageClientThread(String id){
		return (ClientConnectServerThread)hs.get(id);
	}
}
