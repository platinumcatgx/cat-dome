/*
 * 这是一个管理聊天界面的类
 */
package com.qq.client.tools;

import java.util.*;

import com.qq.client.view.QQChat;

public class ManageQQChat {
	private static HashMap hm = new HashMap<String,QQChat>();//String 应该为发送方与接收方的共同信息
	
	public static void addManageQQChat(String ownerAndFriendId, QQChat q){
		hm.put(ownerAndFriendId, q);
	}
	
	public static QQChat getManageQQChat(String ownerAndFriendId){
		return (QQChat)hm.get(ownerAndFriendId);
	}
}
