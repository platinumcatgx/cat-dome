package com.Thread.dome1;

public class MyThread extends Thread {

    public MyThread(String string) {
        this.setName(string);
    }

    /**
     * 这就是线程执行的逻辑体
     */
    @Override
    public void run() {
        for(int i= 0 ; i<=100;i++)
            System.out.println(this.getName()+"下载了"+i+"%");
    }
}
