package GUI.Swing;

import javax.swing.*;
import java.awt.*;

public class ChuangKou {
    public static void main(String[] args) {
        Frame frame = new Frame("我的世界1.14.1");
        frame.setLayout(new FlowLayout(FlowLayout.CENTER , 20 , 30));
        frame.setSize(300,300);//大小
        frame.setLocation(500,500);//显示位置
        frame.add(new JButton("确定"));
        frame.add(new JButton("9696"));
        frame.setVisible(true);

    }


}
