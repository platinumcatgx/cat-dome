package Thread.dome1;

public class test01 {
    public static void main(String[] args) {
        //创建一个线程的对象
        MyThread mt = new MyThread("线程01");
//        mt.run();
        //启动一个线程
        mt.start();



        System.out.println("方法结束");
    }
}
