package platinum_cat_gx.Client.UI;

import org.junit.Test;

import java.awt.*;

public class dl {
//    @Test
    public static void dll(){
        Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
        Frame f = new Frame("DOME:即时通讯_登陆");
        f.setSize(500,360);
        f.setLocation(screenSize.width/2-500/2,screenSize.height/2-360/2);//设置窗口出现位置为屏幕中心
        f.setLayout(null);




        f.setVisible(true);
    }

}
