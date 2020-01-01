package io.github.platinumcat.GUI;

import io.github.platinumcat.model.XiaoXi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FriendList extends JFrame  implements ActionListener, MouseListener {
    private String OwnerId = null;
    private int FriendLength=50;
    /*
    private JPanel head , body , foot;//3个部分
    private String userID=null;

    public FriendList(){
        head = new JPanel();//聊天信息

        body = new JPanel();//查看消息

        foot = new JPanel();//输入消息


        //添加模块,设置属性
        this.setLayout(new GridLayout(3,1));
        this.add(head);
        this.add(body);
        this.add(foot);
        this.setIconImage(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300,500);
        this.setSize(800,600);
        this.setVisible(true);
    }
    */

    //处理第一张卡片
        //按钮 : 好友 ， 黑名单
        JButton haoyou_jb, heimingdan_jb;
        //三张卡片：jp1是最大的，jp2是好友列表，jp3是黑名单
        JPanel jp1, haoyou_jp, heimingdan_jp;
        //滚动条
        JScrollPane haoyou_jsp;
        //好友列表
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

    public FriendList(String OwnerId){
        this.OwnerId = OwnerId;
        //处理第一张卡片
        {
            //初始化按钮
            haoyou_jb = new JButton("我的好友");
            heimingdan_jb = new JButton("黑名单");

            //对黑名单进行监听，如果点击了，打开第二张卡片
            heimingdan_jb.addActionListener(this);

            //初始化大的卡片
            jp1 = new JPanel(new BorderLayout());

            //处理好友列表卡片，假定有50个好友
            haoyou_jp = new JPanel(new GridLayout(FriendLength,1,4,4));//4,4代表好友间隔
            haoyou_jsp = new JScrollPane(haoyou_jp);//滚动条在jp2里面包含

            //初始化50个好友
            haoyou_jbls = new JLabel[FriendLength];
            for(int i=0; i<FriendLength;i++){
                haoyou_jbls[i] = new JLabel(i+1+"", new ImageIcon("dome1/img/登录企鹅.jpg"),JLabel.LEFT);//编号，头像，放到左边
                //默认不在线，除非是自己
                haoyou_jbls[i].setEnabled(false);
                if(haoyou_jbls[i].getText().equals(OwnerId)){
                    haoyou_jbls[i].setEnabled(true);
                }
                haoyou_jbls[i].addMouseListener(this); //当鼠标放到头像上，希望有高亮效果
                haoyou_jp.add(haoyou_jbls[i]);
            }
            //heimingdan_jp是一个1行1列格局，上面有1个按钮。
            heimingdan_jp = new JPanel(new GridLayout(1,1));//1行1列的一个JPanel
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

    /**
     * 更新消息列表
     * @param ms 消息对象
     */
    public void UpdateFriend(XiaoXi ms){
        String onLineFriends[] = ms.getData().split(" ");//用空格分割消息，获得好友字符串数组
        for(int i= 0; i<onLineFriends.length; i++){
            haoyou_jbls[(Integer.parseInt(onLineFriends[i]))-1].setEnabled(true);//把好友信息复制到好友列表
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // 用户双击头像，得到好友的编号
        if(e.getClickCount()==2){
            //得到编号
            String friendNumber = ((JLabel)e.getSource()).getText();
            Chat qqchat = new Chat(this.OwnerId, friendNumber);
//			Thread t = new Thread(qqchat);
//			t.start();
            //把聊天界面加入到管理类中
//            ManageQQChat.addManageQQChat(this.OwnerId+" "+friendNumber, qqchat);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel jl = (JLabel)e.getSource();
        jl.setForeground(Color.red);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel jl = (JLabel)e.getSource();
        jl.setForeground(Color.black);
    }
}
