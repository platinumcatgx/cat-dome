package com.Thread.dome2;

/**
 * 买票的窗口类，创建4个窗口
 */
public class MaiPiao extends Thread{
    private String name;
    /**
     * 定义共享的数据100张票
     */
    static int tickets = 100;
    //创建一个 锁对象 ，这个对象是多个线程共享的数据
    static Object obj = new Object();

    public MaiPiao(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true){
            synchronized(obj){
                if(tickets>0)
                    System.out.println(name+"卖出的票是"+tickets--);
                else
                    break;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name+"买票结束");
    }
}
