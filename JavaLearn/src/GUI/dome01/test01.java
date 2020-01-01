package GUI.dome01;

import javax.swing.*;
import java.awt.*;

public class test01 {
    public static void main(String[] args) {
        JFrame jf = new JFrame("我的世界");
        Container c = jf.getContentPane();//获取一个容器

        JLabel jl = new JLabel("这是一个JLabel窗体");
        jl.setHorizontalAlignment(SwingConstants.CENTER);//使标签文字上下居中

        c.add(jl);
        c.setBackground(Color.cyan);//设置窗口背景颜色
        jf.setVisible(true);//设置可见
        jf.setSize(500,500);//设置窗口的大小
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗口的关闭方式

    }
}
