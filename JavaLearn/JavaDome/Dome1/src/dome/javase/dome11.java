package dome.javase;

public class dome11 {
    public static void main(String[] args) {
        TW task = new TW();
        new Thread(task,"窗口1").start();
        new Thread(task,"窗口2").start();
        new Thread(task,"窗口3").start();
        new Thread(task,"窗口4").start();
    }
}
    class TW implements Runnable{
        private int ts = 10;
        Object lock = new Object();
        @Override
        public void run(){
            while(true) {
                synchronized (lock){
                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    if (ts > 0) {
                        System.out.println(Thread.currentThread().getName()+"---麦出的票"+ ts--);
                    }else {
                        break;
                    }
                }
            }
        }
    }
