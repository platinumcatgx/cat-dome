package io.github.platinumcat.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * 用户注册的界面
 */
public class UserSignIn extends JFrame {
    private JPanel inputJp , jp1,jp2,jp3,jp4;//分割板块
    private JTextField useridJT , userPassWordJT , useridJT2 , userPassWordJT2;//id，密码 输入框
    private JLabel usernameJL , userPassWordJL ,img , usernameJL2 , userPassWordJL2;//输入框对应的提示文字
    private JCheckBox ziDong , jiZhu ; //自动登录 ， jiZhu密码
    private JButton login , signIn , wangji;//登录，注册按钮
    private JLabel j1,j2,j3,j4,j5;
    private String fontName="微软雅黑";
    private int fontSize = 20;

    public UserSignIn() {
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
        userPassWordJT = new JTextField();
        jp2.add(userPassWordJL);
        jp2.add(userPassWordJT);
        jp2.add(j2 = new JLabel());
        //确认密码输入框条
        userPassWordJL2 = new JLabel("确认密码",JLabel.CENTER);
        userPassWordJL2.setFont(new Font(fontName,fontSize,fontSize));
        userPassWordJT2 = new JTextField();
        jp3.add(userPassWordJL2);
        jp3.add(userPassWordJT2);
        jp3.add(j3 = new JLabel());

        //注册按钮
        signIn = new JButton("注册");
        signIn.setFont(new Font(fontName,fontSize-5,fontSize-5));
        jp4.add(j3 = new JLabel());
        jp4.add(signIn);
        jp4.add(j3 = new JLabel());

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
    //点击事件：点击确定会将数据上传到服务器
}
