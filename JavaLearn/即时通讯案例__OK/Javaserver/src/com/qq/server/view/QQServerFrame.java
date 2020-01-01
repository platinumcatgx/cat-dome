/*
 * 服务器端的控制界面，
 * 1.启动服务器界面
 * 2.关闭服务器
 * 3.管理和监控用户 
 */
package com.qq.server.view;

import javax.swing.*;

import com.qq.server.model.MyQQServer;

import java.awt.*;
import java.awt.event.*;

public class QQServerFrame extends JFrame implements ActionListener{
	JPanel jp1;
	JButton jb1, jb2;
	
	public static void main(String[] args) {
		QQServerFrame myserver = new QQServerFrame();
	}
	
	/**
	 * 服务器的界面
	 */
	public QQServerFrame()
	{
		jp1 = new JPanel();
		jb1 = new JButton("启动服务器");
		jb1.addActionListener(this);
		jb2 = new JButton("关闭服务器");
		jp1.add(jb1);
		jp1.add(jb2);
		
		this.add(jp1);
		this.setSize(500,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){//获取来源
			new MyQQServer();
		}
	}

}
