package dome.javase;

public class dome8 {
    public static void main(String[] args) {
        Thread t1 = new Y("a");
        Thread t2 = new Y("b");
        t1.start();
        t2.start();
    }
}

class Y extends Thread{
    public Y(String name) {
        super(name);
    }
    public void run(){
        for (int i = 0; i <6 ; i++) {
            System.out.println(Thread.currentThread().getName()+"---"+i);
            if (i==3){
                System.out.println("线程让步:");
                Thread.yield();
            }
        }
    }
}