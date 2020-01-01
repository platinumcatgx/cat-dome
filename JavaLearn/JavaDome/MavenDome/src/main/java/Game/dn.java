package Game;

import java.util.Random;
import java.util.Scanner;

/**
 * 电脑
 */
public class dn {
    private int sjs;
    private Random random = new Random();

    public dn() {
        this.sjs = random.nextInt(100);
        System.out.println("我想了一个数字,你猜是多少,你一共有6此机会");
    }

    public int getSjs() {
        return sjs;
    }
}

/**
 * 人
 */
class ren{
    private int num;
    private Scanner rs = new Scanner(System.in);

    public int getNum() {
        return num;
    }

    public void sr (){
        System.out.print("我猜这个数是...");
        num=rs.nextInt();
        System.out.println("!");
    }
}

/**
 * 执行者
 */
class zxz{
    public static void main(String[] args) {
        int i = 0;
        dn dn = null;
        ren ren = null;
        //创建电脑并生成一个随机数
        dn = new dn();
        while (true){
            ren = new ren();
            //人猜数字
            ren.sr();
            //判断
            if (ren.getNum()==-1)
                System.exit(0);
            if(i > 7)
                break;
            else
                i++;
            if (dn.getSjs()==ren.getNum()){
                System.out.println("^-^恭喜你猜中了！！！");
                break;
            }else if (dn.getSjs()<ren.getNum()){
                System.out.println("猜错了QAQ，它太大了。");
                continue;
            }else if (dn.getSjs()>ren.getNum()){
                System.out.println("猜错了QAQ,它太小了。");
                continue;
            }
        }
    }
}