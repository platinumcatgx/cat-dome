package Thread.dome4;

/**
 * 并发与并发问题、同步:使共享资源同时只能有一个线程使用
 */
public class test03 {
    public static void main(String[] args) {
//        MaiPiao m1 = new MaiPiao("窗口1");
//        MaiPiao m2 = new MaiPiao("窗口2");
//        MaiPiao m3 = new MaiPiao("窗口3");
//        MaiPiao m4 = new MaiPiao("窗口4");
//
//        m1.start();
//        m2.start();
//        m3.start();
//        m4.start();


        MaiPiaoRun st = new MaiPiaoRun();

        Thread t1 = new Thread(st,"窗口1");
        Thread t2 = new Thread(st,"窗口2");
        Thread t3 = new Thread(st,"窗口3");
        Thread t4 = new Thread(st,"窗口4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
