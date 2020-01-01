package io.github.platinumcat.GUI;

import javax.swing.*;
import java.awt.*;

public class Chat extends JFrame {
    private JPanel head , body , foot;//聊天框的3个部分
    private JLabel jsLable,fsLable,xiaoXiLable;
    private JLabel jlable1 ;
    private JLabel jl1;
    private JTextArea data;//多行文本输入框
    private JButton queRenFS;
    private String fs,js;//发送者，接受者
    private String l="<<<",r=">>>";

    public Chat(String fs , String js){
        //设置发送者，接收者
        this.js = js;
        this.fs = fs;
        head = new JPanel();//聊天信息
        jsLable = new JLabel(js);
        jlable1 = new JLabel(l);
        fsLable = new JLabel(fs);
        head.add(jsLable);
        head.add(jlable1);
        head.add(fsLable);

        body = new JPanel();//查看消息
        xiaoXiLable = new JLabel();
        body.add(xiaoXiLable);

        foot = new JPanel();//输入消息
        data = new JTextArea();
        queRenFS = new JButton("发送");
        foot.add(data);
        foot.add(queRenFS);

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

    public String getFs() {
        return fs;
    }

    public void setFs(String fs) {
        this.fs = fs;
    }

    public String getJs() {
        return js;
    }

    public void setJs(String js) {
        this.js = js;
    }

    public JLabel getXiaoXiLable() {
        return xiaoXiLable;
    }

    public void setXiaoXiLable(JLabel xiaoXiLable) {
        this.xiaoXiLable = xiaoXiLable;
    }

    /**
     * 获取消息列表的内容
     * @return 消息列表的内容
     */
    public String getXiaoXiLableValue() {
        return xiaoXiLable.getText();
    }

    /**
     * 设置消息列表的内容
     * @param value 传入的字符
     */
    public void setXiaoXiLableValue(String value) {
        this.xiaoXiLable.setText(value);
    }

    public static void main(String[] args) {
        new Chat("fa","sdfg");
    }



}
