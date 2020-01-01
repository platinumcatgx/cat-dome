package Dome;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * 当有一类或者一排单选框，或者是复选框，而你刚好希望全部选中，可以执行这一段程序
 */
public class Robot_a {
    public Robot_a() {
        int x=1426,y=247;
        Robot r = null;
        try {
            r = new Robot();
            r.delay(1000*5);
            r.mouseMove(x,y);
            for (int i = 0; i < 2000; i++) {
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                y+=5;
                r.mouseMove(x,y);
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行这个为偷懒而写的方法
     * @param args
     * @throws AWTException
     */
    public static void main(String[] args) throws AWTException {
        Robot_a robot_a = new Robot_a();
    }

}
