package dome.javase;

public class dome9 {
    public static void main(String[] args) {
        Thread t = new Thread(new E(),"yi");
        t.start();
        for (int i = 0; i <6 ; i++) {
            System.out.println(Thread.currentThread().getName()+"输出:"+i);
            try {
                if (i==2)
                    t.join();
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class E implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <6 ; i++) {
            System.out.println(Thread.currentThread().getName()+"输出:"+i);
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
