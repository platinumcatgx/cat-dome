package com.Thread.dome3;

public class MaiPiaoRun implements Runnable {

    String name;

    int tickets = 100;

    Object obj = new Object();

//    public MaiPiaoRun(String name) {
//        this.name = name;
//    }

    @Override
    public void run() {
        while (true){
            synchronized(obj){
                if(tickets>0)
                    System.out.println(Thread.currentThread().getName()+"卖出的票是"+tickets--);
                else
                    break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"买票结束");
    }
}
