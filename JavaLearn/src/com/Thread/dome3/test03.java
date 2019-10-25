package com.Thread.dome3;

/**
 * 并发与并发问题、同步:使共享资源同时只能有一个线程使用
 */
public class test03 {
    public static void main(String[] args) {
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
