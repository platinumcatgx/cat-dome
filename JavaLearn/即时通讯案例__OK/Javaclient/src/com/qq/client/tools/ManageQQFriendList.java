/*
 * 管理好友黑名单类
 */
package com.qq.client.tools;

import java.io.*;
import java.net.*;
import java.util.HashMap;

import org.xml.sax.HandlerBase;

import com.qq.client.view.QQFriendList;

public class ManageQQFriendList {

	private static HashMap hs = new HashMap<String, QQFriendList>();
	
	public static void addManageQQFriendList(String s, QQFriendList q){
		hs.put(s,q);
	}
	
	public static QQFriendList getManageQQFriendList(String s){
		return (QQFriendList)hs.get(s);
	}
	
}
