/*
 * 定义包的种类
 */
package com.qq.common;

public interface MessageType {
	String message_success = "1";//登陆成功
	String message_login_fail = "2";//登陆失败
	String message_common_message = "3";//普通数据包
	String message_get_OnlineFriend = "4";//请求在线好友
	String message_receive_OnlineFriend = "5";//返回在线好友
	String message_receive_QQNumNoExist = "6";//注册QQ号码成功
	String message_receive_QQNumYesExist = "7";//注册QQ号码失败
}
