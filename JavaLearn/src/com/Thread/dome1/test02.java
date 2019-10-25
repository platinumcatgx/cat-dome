package com.Thread.dome1;

/**
 * 方法2
 */
public class test02 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable("name"));
        Thread t2 = new Thread(new MyRunnable("肖申克的救赎"));
        t.start();
        t2.start();
    }
}
