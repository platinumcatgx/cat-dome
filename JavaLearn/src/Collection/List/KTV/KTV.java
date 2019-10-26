package Collection.List.KTV;

import java.util.LinkedList;
import java.util.Scanner;

public class KTV {

    Scanner sr = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList songList = new LinkedList();//歌曲列表
        System.out.println("———————————欢迎来到点歌系统———————————");
        System.out.println("0:打印所有歌曲");
        System.out.println("1:添加歌曲");
        System.out.println("2:置顶歌曲");
        System.out.println("3:将歌曲前移一位");
        System.out.println("4:删除歌曲");
        System.out.println("5:退出");

        while (true){
            System.out.print("///输入要执行的操作序号\n>>>");
            int a = new Scanner(System.in).nextInt();
            switch(a){
                case 0:
                    prinList(songList);
                    break;
                case 1:
                    addSong(songList);
                    break;
                case 2:
                    upSong(songList);
                    break;
                case 3:
                    upASong(songList);
                    break;
                case 4:
                    removeSong(songList);
                    break;
                case 5:
                    exitList();
                    return;
                default:
                    System.out.println("操作错误");
            }
        }

    }

    /**
     * 获取当前列表中歌曲数量
     * @return 歌曲列表几个中的数量
     */
    public static int getCountSong(LinkedList songList) {
        return songList.size();
    }

    /**
     * 添加歌曲
     * @param songList
     */
    public static void addSong(LinkedList songList){
        System.out.print("输入需要添加的歌曲\n>>>");
        String song = new Scanner(System.in).nextLine();
        if(song!=""){
            songList.add(song);
        }else {
            System.out.println("！！歌曲不能为空！！");
        }
        System.out.println("歌曲"+song+"添加完毕");
    }

    /**
     * 删除某歌曲
     */
    public static void removeSong(LinkedList songList){
        System.out.print("输入需要删除的歌曲\n>>>");
        String str = new  Scanner(System.in).nextLine();
        if (songList.indexOf(str)>0) {
            songList.remove(str);
        } else {
            System.out.println("！！删除错误：歌曲不存在！！");
        }
        System.out.println("歌曲"+str+"删除完毕");
    }

    /**
     * 歌曲置顶
     */
    public static void upSong(LinkedList songList){
        System.out.print("输入要置顶的歌曲名\n>>>");
        String str = new Scanner(System.in).nextLine();
        int a = songList.indexOf(str);
        if(a<0){
            System.out.println("歌曲不存在");
        }else {
            songList.remove(str);
            songList.addFirst(str);
        }
        System.out.println("已将歌曲"+str+"置顶");
    }

    /**
     * 将歌曲前置一位
     */
    public static void upASong(LinkedList songList){
        System.out.print("输入要前移的歌曲名\n>>>");
        String str = new Scanner(System.in).nextLine();
        int a = songList.indexOf(str);
        if(a<0) {
            System.out.println("歌曲不存在");
        }else if(a==0){
            System.out.println("歌曲已在第一位");
        }else {
            songList.remove(str);
            songList.add(a-1,str);
        }
        System.out.println("已将歌曲"+str+"前移一位");
    }

    /**
     * 打印歌曲列表
     */
    public static void prinList(LinkedList songList){
        System.out.println("歌曲数量"+getCountSong(songList));
        for(int i=0;i<songList.size();i++){
            System.out.println(i+" : "+songList.get(i));
        }
    }

    public static void exitList(){
        System.out.println("————————退出播放————————");
    }
}
