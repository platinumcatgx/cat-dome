package com.qq.client.view;

import javax.swing.*;

import com.qq.client.model.QQClientUser;
import com.qq.common.*;
import com.qq.client.tools.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;


/*
 * 客户端登录界面：
 * 一共是三部份：最上面是一个整体的图片；然后中间是三张卡年，每个卡片是三行三列；最后是一行三列
 */
public class QQClientLogin extends JFrame implements ActionListener{

	//定义最上面的组件
	JLabel jl1;
	
	//由选项卡窗口管理JTabbedPane
	JTabbedPane jtp;
	//定义中间的组件，中部有四个JPanel
	JPanel jp2, jp3, jp4,jp5,jp6,jp7;
	JLabel jp3_jl1,jp3_jl2, jp4_j11,jp4_j12;
	JButton jp5_jbt, jp6_jbt;
	JTextField jp3_jtf; //账号输入框
	JPasswordField jp4_jpf;//密码输入框
	JCheckBox jp5_jcb1, jp5_jcb2;  //复选框
	
	
	
	//定义最下面的组件
	JPanel jp1;
	JButton jp1_jb1;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QQClientLogin cclientLogin = new QQClientLogin();
	}
	
	public QQClientLogin()
	{
		//处理最上面
		jl1 = new JLabel(new ImageIcon("top.jpg"));
		
		//处理中间，使用网格布局管理器
		jp2 = new JPanel(new GridLayout(4,1));
		jp3 = new JPanel(new GridLayout(1,3));
		jp4 = new JPanel(new GridLayout(1,3));
		jp5 = new JPanel();
		jp6 = new JPanel(new GridLayout(1,1));
		
		jp3_jl1 = new JLabel("QQ号码",JLabel.CENTER);
		jp3_jtf = new JTextField();
		jp3_jl2 = new JLabel(new ImageIcon("登录企鹅.jpg"));
		jp3.add(jp3_jl1);
		jp3.add(jp3_jtf);
		jp3.add(jp3_jl2);
		
		jp4_j11 = new JLabel("QQ密码",JLabel.CENTER);		
		jp4_jpf = new JPasswordField();//密码框
		jp4_j12 = new JLabel(new ImageIcon("锁.jpg"));
		jp4.add(jp4_j11);
		jp4.add(jp4_jpf);
		jp4.add(jp4_j12);
		
		
		jp5_jcb1 = new JCheckBox("自动登录");
		jp5_jcb2 = new JCheckBox("记住密码");
		jp5_jbt = new JButton("找回密码");
		jp5.add(jp5_jcb1);
		jp5.add(jp5_jcb2);
		jp5.add(jp5_jbt);
		

		jp6_jbt = new JButton("登录");
		//响应用户点击的登录
		jp6_jbt.addActionListener(this);
		jp6.add(jp6_jbt);
				
		
		//把控件按照顺序加入到jp2中
		jp2.add(jp3);
		jp2.add(jp4);
		jp2.add(jp5);
		jp2.add(jp6);
		
		//另一个卡片
		jtp = new JTabbedPane();
		jtp.add("QQ号码登录",jp2);
		jp7 = new JPanel();
		jtp.add("手机号码登录",jp7);//待完成
		
		
		//处理最下面
		jp1 = new JPanel();
		jp1_jb1 = new JButton("注册账号");
		jp1_jb1.addActionListener(this);
		jp1.add(jp1_jb1,"LEFT");
				
		
		this.add(jl1,"North");
		this.add(jtp,"Center");		
		this.add(jp1, "South");
		this.setIconImage((new ImageIcon("企鹅.jpg").getImage()));
		this.setSize(540,420);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//如果用户点击登录
		if(e.getSource()== jp6_jbt){
			QQClientUser qqClientUser = new QQClientUser();
			User u = new User();
			u.setIfNew(2);//已存在用户
			u.setUserId(jp3_jtf.getText().trim());//密码与账号的处理方式不一样
			u.setPasswd(new String(jp4_jpf.getPassword()));
			
			if(qqClientUser.checkUser(u))
			{
				//登陆成功，发送一个请求好友的包
				try {
					//可以进入好友界面
					QQFriendList qqfriendlist = new QQFriendList(u.getUserId());
					ManageQQFriendList.addManageQQFriendList(u.getUserId(), qqfriendlist);
					
					ObjectOutputStream oos = new ObjectOutputStream(ManageClientConServerThread.getManageClientThread(u.getUserId()).getS().getOutputStream());
					
					Message ms = new Message();
					ms.setMesType(MessageType.message_get_OnlineFriend);
					ms.setSender(u.getUserId());//指明我要的是这个qq号码的好友在线现状
					oos.writeObject(ms);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				//同时关闭掉登录界面
				this.dispose();
			}else{
				//不成功，跳出一个对话框
				JOptionPane.showMessageDialog(this, "用户名密码错误");
			}
			
		}
		else if(e.getSource()== jp1_jb1){//注册界面			
			QQClientRegister qqcr = new QQClientRegister();
			//同时关闭掉登录界面
			this.dispose();
		}
		
	}

}
