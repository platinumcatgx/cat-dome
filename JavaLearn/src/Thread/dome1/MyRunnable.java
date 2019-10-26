package Thread.dome1;

public class MyRunnable implements Runnable{
    private String name;
    public MyRunnable(String name) {
        this.name=name;
    }

    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            System.out.println(name+"下载了"+i+"%");
        }
    }
}
