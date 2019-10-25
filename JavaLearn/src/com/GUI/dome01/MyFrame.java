package com.GUI.dome01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class MyDialog extends JDialog{
    public MyDialog(MyFrame myFrame) {
        super(myFrame , "第一个弹窗" , true);
        Container container = getContentPane();//创建一个容器
        container.add(new JLabel("这是一个小弹窗"));//在容器中添加内容
        setBounds(300 , 300, 100 , 100 );//设置对话框的窗体大小
    }
}

public class MyFrame extends JFrame {
    public static void main(String[] args) {
        new MyFrame();
    }

    public MyFrame(){
        Container container = getContentPane();
        container.setLayout(null);
        JLabel jLabel = new JLabel("这是一个JLabel对话狂");
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(jLabel);

        JButton jButton = new JButton("弹出你的第一个对话框");
        jButton.setBounds(10 ,10,100,21);
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyDialog(MyFrame.this).setVisible(true);
            }
        });
        container.add(jButton);

    }
}

