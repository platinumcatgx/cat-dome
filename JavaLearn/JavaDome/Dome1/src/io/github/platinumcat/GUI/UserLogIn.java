package io.github.platinumcat.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 用户登录的界面
 */
public class UserLogIn extends JFrame implements ActionListener {
    private JPanel inputJp , jp1,jp2,jp3,jp4;//分割板块
    private JTextField useridJT , userPassWordJT;//id，密码 输入框
    private JLabel usernameJL , userPassWordJL ,img;//输入框对应的提示文字
    private JCheckBox ziDong , jiZhu ; //自动登录 ， jiZhu密码
    private JButton login , signIn , wangji;//登录，注册按钮
    private JLabel j1,j2,j3,j4;
    private String fontName="微软雅黑";
    private int fontSize = 20;

    public UserLogIn() {
        img = new JLabel(new ImageIcon("dome1/img/top.jpg"));//设置上方的图片

        inputJp = new JPanel(new GridLayout(4,1));//创造7行3列的网格布局
        jp1 = new JPanel(new GridLayout(1,3));
        jp2 = new JPanel(new GridLayout(1,3));
        jp3 = new JPanel(new GridLayout(1,3));
        jp4 = new JPanel(new GridLayout(1,3));

        //id输入框条
        usernameJL = new JLabel("账号",JLabel.CENTER);
        usernameJL.setFont(new Font("微软雅黑",fontSize,fontSize));
        useridJT = new JTextField();
        jp1.add(usernameJL);
        jp1.add(useridJT);
        jp1.add(j1 = new JLabel());
        //密码输入框条
        userPassWordJL = new JLabel("密码",JLabel.CENTER);
        userPassWordJL.setFont(new Font(fontName,fontSize,fontSize));
        userPassWordJT = new JPasswordField();
        jp2.add(userPassWordJL);
        jp2.add(userPassWordJT);
        jp2.add(j2 = new JLabel());
        //选项条
        ziDong = new JCheckBox("自动登录");
        jiZhu = new JCheckBox("记住密码");
        ziDong.setFont(new Font(fontName,fontSize-5,fontSize-5));
        jiZhu.setFont(new Font(fontName,fontSize-5,fontSize-5));
        wangji = new JButton("忘记密码");
        wangji.setFont(new Font(fontName,fontSize-5,fontSize-5));
        jp3.add(j3 = new JLabel());
        jp3.add(ziDong);
        jp3.add(wangji);
        jp3.add(jiZhu);
        jp3.add(j4 = new JLabel());

        login = new JButton("登录");
        login.setFont(new Font(fontName,fontSize-5,fontSize-5));
        signIn = new JButton("注册");
        signIn.setFont(new Font(fontName,fontSize-5,fontSize-5));
        jp4.add(login);
        jp4.add(signIn);

        inputJp.add(jp1);
        inputJp.add(jp2);
        inputJp.add(jp3);
        inputJp.add(jp4);

        //设置大小，可见等属性
        this.setLayout(new GridLayout(2,1));
        this.add(img);
        this.add(inputJp);
        this.setIconImage((new ImageIcon("dome1/img/企鹅.jpg").getImage()));
        this.setSize(540,420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    //点击事件：点击登录，注册，忘记密码会发生对应事件
    @Override
    public void actionPerformed(ActionEvent e) {
        //如果点击的是登录
        if (e.getSource()==login){//登录

        }else if(e.getSource()==signIn){//注册

        }else if(e.getSource()==ziDong){//自动登录

        }else if(e.getSource()==jiZhu){//记住密码

        }else if(e.getSource()==wangji){//忘记密码

        }else {

        }
    }
}
