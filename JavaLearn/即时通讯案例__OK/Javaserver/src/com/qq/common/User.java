/*
 * 用户信息类
 */
package com.qq.common;

public class User implements java.io.Serializable{
	private String userId;
	private String passwd;
	private int IfNew;//用来标识这个用户是否是新用户，如果是注册页面的user，就为1表示新用户；如果是登录页面的user，就为2表示已存在用户
	
	public int getIfNew() {
		return IfNew;
	}
	public void setIfNew(int ifNew) {
		IfNew = ifNew;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
}
