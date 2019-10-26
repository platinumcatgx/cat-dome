package IO.books;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
    public static final String SEPARATE_FIELD=",";
    public static final String SEPARATE_liNE="\r\n";

    /**
     * 保存图书信息
     * @param books
     */
    public static void saveBooks(Books books){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        String name = "销售记录"+format.format(date)+".csv";//拼凑出文件名
        InputStream in = null;
        try{
            in = new FileInputStream(name);
            if(in!=null){
                in.close();//关闭输入流
                createFile(name,true,books);//追加文件
            }
        }catch(FileNotFoundException e){
            createFile(name,false,books);//新建文件
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * 将图书信息保存到本地，如果文件已存在，追加；不存在，创建
     * @param name 文件
     * @param label 是否存在文件
     * @param books 图书信息
     */
    public static void createFile(String name,boolean label , Books books){
        BufferedOutputStream out = null;
        StringBuffer sbf = new StringBuffer();//拼接内容
        try{
            if(label){//如果存在当天的文件，追加
                out = new BufferedOutputStream(new FileOutputStream(name,true));
            }else{//不存在当天记录，创建
                out = new BufferedOutputStream(new FileOutputStream(name,false));
                //创建表头
                String[] fileldSort = new String[]{"图书编号","图书名称","购买数量","单价","总价","出版社"};
                for(String fieldKey : fileldSort){
                    //存储表头
                    sbf.append(fieldKey).append(SEPARATE_FIELD);
                }
            }
            sbf.append(SEPARATE_liNE);//追加换行符
            sbf.append(books.id).append(SEPARATE_FIELD);
            sbf.append(books.name).append(SEPARATE_FIELD);
            sbf.append(books.number).append(SEPARATE_FIELD);
            sbf.append((double)books.price).append(SEPARATE_FIELD);
            sbf.append((double)books.money).append(SEPARATE_FIELD);
            sbf.append(books.Publish).append(SEPARATE_FIELD);
            String str = sbf.toString();
            byte[] b=str.getBytes();
            for(int i=0;i<b.length;i++){
                out.write(b[i]);//将内容写入本地
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(out!=null)
                    out.close();//关闭流
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }

    }
}

