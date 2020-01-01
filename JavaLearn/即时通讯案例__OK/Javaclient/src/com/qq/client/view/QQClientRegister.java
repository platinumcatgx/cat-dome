package com.qq.client.view;

import javax.swing.*;

import com.qq.client.model.QQClientUser;
import com.qq.common.*;
import com.qq.client.tools.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class QQClientRegister extends JFrame implements ActionListener{
			
	//定义中间的组件，中部有四个JPanel
	JPanel jp1, jp2, jp3,jp4,jp5;
	JLabel jp_jl1,jp_jl2, jp_jl3 , jp_jl4,jp_jl5,jp_jl6;
	JButton jp_jbt;//按钮
	JTextField jp_jtf; //账号输入框
	JPasswordField jp_jpf1,jp_jpf2;//密码输入框
	
	
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QQClientRegister qq = new QQClientRegister();
		
	}
	
	public QQClientRegister()
	{		
		//处理大框架
		jp5 = new JPanel(new GridLayout(4,1));
		jp1 = new JPanel(new GridLayout(1,3));
		jp2 = new JPanel(new GridLayout(1,3));
		jp3 = new JPanel(new GridLayout(1,3));
		jp4 = new JPanel(new GridLayout(1,1));		
		
		jp_jl1 = new JLabel("QQ号码",JLabel.CENTER);
		jp_jtf = new JTextField();
		jp_jl4 = new JLabel(new ImageIcon("登录企鹅.jpg"));
		jp1.add(jp_jl1);
		jp1.add(jp_jtf);
		jp1.add(jp_jl4);
		
		jp_jl2 = new JLabel("请输入密码",JLabel.CENTER);		
		jp_jpf1 = new JPasswordField();//密码框
		jp_jl5 = new JLabel(new ImageIcon("锁.jpg"));
		jp2.add(jp_jl2);
		jp2.add(jp_jpf1);
		jp2.add(jp_jl5);
		
		jp_jl3 = new JLabel("请再次输入密码",JLabel.CENTER);		
		jp_jpf2 = new JPasswordField();//密码框
		jp_jl6 = new JLabel(new ImageIcon("锁.jpg"));
		jp3.add(jp_jl3);
		jp3.add(jp_jpf2);
		jp3.add(jp_jl6);
		
		jp_jbt = new JButton("注册");
		//响应用户点击的登录
		jp_jbt.addActionListener(this);
		jp4.add(jp_jbt);
				
		
		//把控件按照顺序加入到jp2中
		jp5.add(jp1);
		jp5.add(jp2);
		jp5.add(jp3);
		jp5.add(jp4);
		
		this.add(jp5,"Center");	
		this.setTitle("注册");
		this.setIconImage((new ImageIcon("企鹅.jpg").getImage()));
		this.setSize(400,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//点击注册
		if(e.getSource() == jp_jbt){
			//1.先判断两个密码输入是否一致
			if(!(jp_jpf1.getText().equals(jp_jpf2.getText()))){
				//不成功，跳出一个对话框
				JOptionPane.showMessageDialog(this, "两次密码不一致");
			}else{
				//2.判断qq号是否存在，我将数据库qq号添加了唯一约束。
				//将输入的账号和密码封装成user，发送到服务器去处理。
				User u = new User();
				u.setIfNew(1);//新用户
				u.setUserId(jp_jtf.getText().trim());
				u.setPasswd(new String(jp_jpf1.getPassword()));
				QQClientUser qqClientUser = new QQClientUser();	
		
				if(!(qqClientUser.checkQQnumberIfExist(u))){
					//如果用户已经存在，则跳出一个对话框说“用户已存在”
					JOptionPane.showMessageDialog(this, "用户已存在");
				}else{
					//如果用户不存在，则将数据存入到数据库中，并且打开login界面。
					JOptionPane.showMessageDialog(this, "账户创建成功，可以登录聊天啦！");
					//打开login界面
					QQClientLogin qqcl = new QQClientLogin();
					//同时关闭掉登录界面
					this.dispose();
				}
				
				
			}
			
		}
		
	}


}







