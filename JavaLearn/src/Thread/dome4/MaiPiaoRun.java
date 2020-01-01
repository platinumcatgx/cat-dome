package Thread.dome4;

public class MaiPiaoRun implements Runnable {

    String name;

    int tickets = 100;

    Object obj = new Object();

    @Override
    public void run() {
        while (true){
            if(maiPiao())
                break;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"买票结束");
    }

//    public boolean maiPiao(){
//        boolean isFinsh = false;
//        synchronized(obj){
//            if(tickets>0)
//                System.out.println(Thread.currentThread().getName()+"卖出的票是"+tickets--);
//            else
//                isFinsh = true;
//        }
//        return isFinsh;
//    }


    /**
     * 整个方法都是synchronized ， 加关键字synchronized，锁的对象是this
     * @return
     */
    public synchronized boolean maiPiao(){
        boolean isFinsh = false;
            if(tickets>0)
                System.out.println(Thread.currentThread().getName()+"卖出的票是"+tickets--);
            else
                isFinsh = true;
        return isFinsh;
    }



}
