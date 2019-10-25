package com.Collection.List.Set;

import java.util.Date;

public class User {
	private String userName;
	private String password;
	private Date birthday;
	private String telNumber;
	private String email;
	
	public User() {}
	public User(String userName, String password, Date birthday, String telNumber, String email) {
		this.userName = userName;
		this.password = password;
		this.birthday = birthday;
		this.telNumber = telNumber;
		this.email = email;
	}
	
	//��дhashCode��equals���������û�����Ϊ�Ƿ��ظ�������
	public int hashCode() {
		return userName.hashCode();
	}
	public boolean equals(Object obj) {
		if(this==obj) {//�ж��Ƿ�ͬһ������
			return true;
		}
		if(obj==null) {//�ж��Ƿ�Ϊ��
			return false;
		}
		if(getClass()!=obj.getClass()) {//�ж���������Ƿ���User����
			return false;
		}
		User other=(User)obj;
		if(userName==null) {//�жϼ������û����Ƿ�Ϊ��
			if(other.userName!=null) {//�ж϶������û����Ƿ�
				return false;//�������û���Ϊ��&&�����û�����Ϊ�գ�����false
			}
		}else if(!userName.equals(other.userName)){//�ж��û����Ƿ���ͬ
			return false;
		}
		return true;
	}
}
