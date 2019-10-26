package IO.File.notepad;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class notepad {
    private static String filePath;
    private static String message="";

    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("--1:新建文件  2:打开文件  3:修改文件  4:保存  5:退出--");
        while(true){
            System.out.println("请输入着指令:");
            int command = sc.nextInt();
            switch(command){
                case 1:
                    creatFile();
                    break;
                case 2:
                    openFile();
                    break;
                case 3:
                    editFile();
                    break;
                case 4:
                    saveFile();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("请输入的指令有误！");
                    break;
            }
        }
    }

    /**
     * 创建文件
     */
    private static void creatFile() {
        message = "";//新建文件时，暂存文件内容清空
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入内容，停止编写请您输入“stop”:");
        StringBuffer stb = new StringBuffer();//用于后期输入内容的拼接
        String inputMessage="";
        while(!inputMessage.equals("stop")){//当输入stop时，停止输入
            if(stb.length()>0){
                stb.append("\r\n");//追加换行符
            }
            stb.append(inputMessage);//输入拼接信息
            inputMessage = sc.nextLine();
        }
        message = stb.toString();//将输入内容暂存
    }

    /**
     * 打开文件
     * @throws IOException
     */
    private static void openFile() throws IOException {
        message = "";//打开文件时，将暂存内容清空
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入打开文件的位置");
        filePath=sc.next();
        //控制只能打开txt格式的文件路径
        if(filePath!=null && !filePath.endsWith(".txt")){
            System.out.println("请选择文本文件!");
            return;
        }

        FileReader in =new FileReader(filePath);//实例化一个FileReader对象
        char[] charArray = new char[1024];//缓冲数组
        int len = 0;
        StringBuffer sb = new StringBuffer();
        //循环读取，一次读取一个数组
        while((len = in.read(charArray))!=-1){
            sb.append(charArray);
        }
        message = sb.toString();//将打开文件内容暂存
        System.out.println("打开文件内容:"+"\r\n"+message);
        in.close();//释放资源
    }

    /**
     * 修改
     */
    private static void editFile() {
        if(message=="" && filePath == null){
            System.out.println("请先打开文件夹或文件");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的内容（以\"修改的目标文字：修改之后的文字\"格式）,"+"停止修改请输入\"stop\":");
        String inputMessage="";
        while(!inputMessage.equals("stop")){
            inputMessage = sc.nextLine();//输入
            if(inputMessage!=null && inputMessage.length()>0){//如果输入不为空
                String[] editMessage=inputMessage.split(":");
                if(editMessage != null && editMessage.length>1){//修改内容不为空
                    message = message.replace(editMessage[0],editMessage[1]);
                }
            }
            System.out.println("修改后的内容"+"\r\n"+message);
        }
    }

    /**
     * 保存文件
     * @throws IOException
     */
    private static void saveFile() throws IOException {
        Scanner sc = new Scanner(System.in);
        FileWriter out = null;
        if(filePath!=null){//文件是由”打开“载入的
            out = new FileWriter(filePath);//将源文件覆盖
        }else{//新建文件
            System.out.println("请输入文件保存的绝对路径：");
            String path = sc.next();//获取文件保存的绝对路径
            filePath = path;

            if(!filePath.toLowerCase().endsWith(".txt")){
                filePath += ".txt";
            }

            out = new FileWriter(filePath);//构造输出流

            out.write(message);//写入暂存的内容
            out.close();//关闭输出流
            message = "";//修改文件前现将写入内容置空
            filePath = null;//将文件路径至null
        }
    }

    /**
     * 退出
     */
    private static void exit() {
        System.out.println("你已退出系统，谢谢使用！");
        System.exit(0);
    }
}
