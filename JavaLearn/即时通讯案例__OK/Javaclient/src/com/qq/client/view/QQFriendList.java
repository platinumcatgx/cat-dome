
package com.qq.client.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import com.qq.client.tools.*;
/*
 * 我的好友列表：也包括陌生人、黑名单
 * 分析思路：
 */
import com.qq.common.Message;

public class QQFriendList extends JFrame implements ActionListener, MouseListener{

	private String OwnerId = null;
	//处理第一张卡片
		//按钮
		JButton haoyou_jb, heimingdan_jb;
		//三张卡片：jp1是最大的，jp2是好友列表，jp3是黑名单
		JPanel jp1, haoyou_jp, heimingdan_jp;	
		//滚动条
		JScrollPane haoyou_jsp;
	
		JLabel haoyou_jbls[];
	
	//处理第2张卡片
		//按钮
		JButton haoyou_jb2, heimingdan_jb2;
		//三张卡片：jp1是最大的，jp2是好友列表，jp3是黑名单
		JPanel jp21, haoyou_jp2, heimingdan_jp2;	
		//滚动条
		JScrollPane heimingdan_jsp2;

	//把整个JFrame设置成CardLayout布局
		CardLayout c1;
		
	public static void main(String[] args) {
	//	QQFriendList  ql = new QQFriendList("null");
	}
	
	//更新在线好友情况
	public void UpdateFriend(Message ms){
		String onLineFriends[] = ms.getCon().split(" ");
		
		for(int i= 0; i<onLineFriends.length; i++){
			haoyou_jbls[(Integer.parseInt(onLineFriends[i]))-1].setEnabled(true);
		}
	}
	
	
	public QQFriendList(String OwnerId)
	{
		this.OwnerId = OwnerId;
		//处理第一张卡片
		{
			haoyou_jb = new JButton("我的好友");
			heimingdan_jb = new JButton("黑名单");
			//对黑名单进行监听，如果点击了，打开第二张卡片
			heimingdan_jb.addActionListener(this);

			//初始化大的卡片
			jp1 = new JPanel(new BorderLayout());
				
			//处理好友列表卡片，假定有50个好友
			haoyou_jp = new JPanel(new GridLayout(50,1,4,4));//4,4代表好友间隔
			haoyou_jsp = new JScrollPane(haoyou_jp);//滚动条在jp2里面包含
			
			//初始化50个好友
			haoyou_jbls = new JLabel[50];
			for(int i=0; i<50;i++){
				haoyou_jbls[i] = new JLabel(i+1+"", new ImageIcon("登录企鹅.jpg"),JLabel.LEFT);//编号，头像，放到左边 
				
				//默认不在线，除非是自己
				haoyou_jbls[i].setEnabled(false);
				if(haoyou_jbls[i].getText().equals(OwnerId)){
					haoyou_jbls[i].setEnabled(true);
				}
				
				haoyou_jbls[i].addMouseListener(this); //当鼠标放到头像上，希望有高亮效果
				haoyou_jp.add(haoyou_jbls[i]);
				
			}
			
			//heimingdan_jp是一个1行1列格局，上面有1个按钮。
			heimingdan_jp = new JPanel(new GridLayout(2,1));//1行1列的一个JPanel
			heimingdan_jp.add(heimingdan_jb);
				
			
			//将haoyou_jb、heimingdan_jp放入到jp1里面去
			jp1.add(haoyou_jb,"North");
			jp1.add(haoyou_jsp,"Center");
			jp1.add(heimingdan_jp,"South");
		}
		
		
		//处理第二张卡片
		{
			//初始化按钮
			haoyou_jb2 = new JButton("我的好友");
			haoyou_jb2.addActionListener(this);
			heimingdan_jb2 = new JButton("黑名单");

			//初始化大的卡片
			jp21 = new JPanel(new BorderLayout());
			
			//haoyou_jp是一个1行1列格局，上面有1个按钮。
			haoyou_jp2 = new JPanel(new GridLayout(2,1));
			haoyou_jp2.add(haoyou_jb2);
			haoyou_jp2.add(heimingdan_jb2);
			
			
			//处理黑名单列表卡片，假定有20个
			heimingdan_jp2 = new JPanel(new GridLayout(20,1,4,4));//4,4代表好友间隔
			heimingdan_jsp2 = new JScrollPane(heimingdan_jp2);//滚动条在jsp2里面包含
			
			//初始化50个好友
			JLabel heimingdan_jbls[] = new JLabel[20];
			for(int i=0; i<20;i++){
				heimingdan_jbls[i] = new JLabel(i+1+"", new ImageIcon("登录企鹅.jpg"),JLabel.LEFT);//编号，头像，放到左边 
				heimingdan_jp2.add(heimingdan_jbls[i]);
			}
			
			//将haoyou_jb2、jp3放入到jp21里面去
			jp21.add(haoyou_jp2,"North");
			jp21.add(heimingdan_jsp2); 
			
		}
		
		
		//把整个JFrame设置成CardLayout布局
		c1 = new CardLayout();
		this.setLayout(c1);
		this.add(jp1,"1");
		this.add(jp21,"2");
		
		//在窗口显示自己的QQ号
		this.setTitle(OwnerId);
		this.setIconImage((new ImageIcon("企鹅.jpg").getImage()));
		this.setSize(400,600);//设置页面大小
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 如果点击了陌生人按钮，就显示第二张卡片
		if(e.getSource() == heimingdan_jb){
			c1.show(this.getContentPane(), "2");
		}else if(e.getSource() == haoyou_jb2){
			c1.show(this.getContentPane(), "1");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// 用户双击头像，得到好友的编号
		if(e.getClickCount()==2){
			//得到编号
			String friendNumber = ((JLabel)e.getSource()).getText();
			QQChat qqchat = new QQChat(this.OwnerId, friendNumber);
			
//			Thread t = new Thread(qqchat);
//			t.start();
			
			//把聊天界面加入到管理类中
			ManageQQChat.addManageQQChat(this.OwnerId+" "+friendNumber, qqchat);
			
			

		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jl = (JLabel)e.getSource();
		jl.setForeground(Color.red);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jl = (JLabel)e.getSource();
		jl.setForeground(Color.black);
	}

}

