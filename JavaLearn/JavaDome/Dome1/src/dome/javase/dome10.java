package dome.javase;

public class dome10 {
    public static void main(String[] args) {
        T t = new T();
        new Thread(t,"1").start();
        new Thread(t,"2").start();
        new Thread(t,"3").start();
        new Thread(t,"4").start();

    }
}
class T implements Runnable{
    private int ts = 10;
    @Override
    public void run() {
        while (ts>0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"---卖出的票"+ts--);
        }
    }
}
