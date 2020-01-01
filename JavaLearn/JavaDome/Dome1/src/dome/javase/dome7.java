package dome.javase;

public class dome7 {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i <10 ; i++) {
                    try{
                        if (i==3)
                            Thread.sleep(2000);
                        else
                            Thread.sleep(500);
                        System.out.println("线程1正在输出"+i);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        a.start();
        for (int i = 0; i <10 ; i++) {
            if (i==5){
                Thread.sleep(2000);
            }else {
                Thread.sleep(500);
            }
            System.out.println("main主线程正在输出"+i);
        }
    }
}