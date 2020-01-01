package cs;

import java.io.IOException;

/**
 * 调用命令窗口
 */
public class cs {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("notepad.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("打开完毕。");
    }
}
