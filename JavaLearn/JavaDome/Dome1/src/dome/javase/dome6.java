package dome.javase;

public class dome6 {
    public static void main(String[] args) {
        Thread a = new Thread(new a(), "TOP.10");
        Thread b = new Thread(new a(), "TOP.1");
        a.setPriority(Thread.MAX_PRIORITY);
        b.setPriority(Thread.MIN_PRIORITY);
        a.start();
        b.start();
    }
}
class a implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"正在输出"+i);
        }
    }
}
