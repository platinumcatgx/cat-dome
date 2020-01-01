package Thread.dome2;

/**
 * 并发与并发问题、同步:使共享资源同时只能有一个线程使用
 */
public class test03 {
    public static void main(String[] args) {
        MaiPiao m1 = new MaiPiao("窗口1");
        MaiPiao m2 = new MaiPiao("窗口2");
        MaiPiao m3 = new MaiPiao("窗口3");
        MaiPiao m4 = new MaiPiao("窗口4");

        m1.start();
        m2.start();
        m3.start();
        m4.start();

    }
}
