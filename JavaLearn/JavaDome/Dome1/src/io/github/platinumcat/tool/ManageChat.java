/*
 * 这是一个管理聊天界面的类
 */
package io.github.platinumcat.tool;

import io.github.platinumcat.GUI.Chat;

import java.util.*;

public class ManageChat {
	private static HashMap hm = new HashMap<String, Chat>();//String 应该为发送方与接收方的共同信息
	
	public static void addManageQQChat(String ownerAndFriendId, Chat q){
		hm.put(ownerAndFriendId, q);
	}
	
	public static Chat getManageQQChat(String ownerAndFriendId){
		return (Chat)hm.get(ownerAndFriendId);
	}
}
