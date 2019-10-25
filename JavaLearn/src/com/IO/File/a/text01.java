package com.IO.File.a;

import java.io.*;

public class text01 {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("src/IO.File/src.txt");
        BufferedReader br = new BufferedReader(reader);//打开一个缓冲读取字符流

        FileWriter writer = new FileWriter("src/IO.File/tostc.txt");
        BufferedWriter bw = new BufferedWriter(writer);//打开一个缓冲写入字符流
        String str ;
        while((str = br.readLine())!=null){//读取一整行数据
            bw.write(str);//输入
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
