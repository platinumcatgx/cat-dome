package GUI.dome01;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class TuBiao extends JFrame {
    public TuBiao() {
        Container container = getContentPane();
        JLabel jl = new JLabel("这是一个JFrame窗体",JLabel.CENTER);

        //获取图片所在的URL
        URL url = TuBiao.class.getResource("java1.jpg");
        Icon icon = new ImageIcon(url);//实例化icon对象
        jl.setIcon(icon);//为JLabel设置图标

        jl.setHorizontalAlignment(SwingConstants.CENTER);
        jl.setOpaque(true);//设置标签为不透明状态

        container.add(jl);
        setSize(250,100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TuBiao();
    }
}
