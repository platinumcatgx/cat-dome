package com.IO.ZiJie;

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

    public static void saveBooks(Books books){
        //�жϱ����Ƿ���ڴ��ļ�
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");//�������ڸ�ʽ
        String name = "���ۼ�¼"+format.format(date)+".csv";//ƴ���ļ���
        InputStream in = null;
        try{
            in = new FileInputStream(name);//�жϱ����Ƿ���ڴ��ļ�
            if(in!=null){
                in.close();
                createFile(name,true,books);//�����ļ���ȡ�޸ķ�ʽ
            }
        }catch(FileNotFoundException e){
            createFile(name,false,books);//�������ļ�����ȡ�½��ļ���ʽ
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * ��ͼ����۳���Ϣ���浽���أ�����ͨ��lable��ʾ���ж����޸Ļ����½��ļ�
     * @param name �ļ���
     * @param label �ļ���ʾ���Ƿ����
     * @param books ͼ����Ϣ
     */
    public static void createFile(String name,boolean label , Books books){
        BufferedOutputStream out = null;
        StringBuffer sbf = new StringBuffer();//ƴ������
        try{
            if(label){//�ļ�����,���ļ����ݺ�׷��
                out = new BufferedOutputStream(new FileOutputStream(name,true));
            }else{//�����ڣ������ļ�
                out = new BufferedOutputStream(new FileOutputStream(name,false));
                String[] fileldSort = new String[]{"ͼ����","ͼ������","��������","����","�ܼ�","������"};
                //������ͷ
                for(String fieldKey : fileldSort){
                    //�½�ʱ������ͷ���뱾���ļ�
                    sbf.append(fieldKey).append(SEPARATE_FIELD);
                }
            }
            sbf.append(SEPARATE_liNE);//׷�ӻ��з�
            sbf.append(books.id).append(SEPARATE_FIELD);
            sbf.append(books.name).append(SEPARATE_FIELD);
            sbf.append(books.number).append(SEPARATE_FIELD);
            sbf.append((double)books.price).append(SEPARATE_FIELD);
            sbf.append((double)books.money).append(SEPARATE_FIELD);
            sbf.append(books.Publish).append(SEPARATE_FIELD);
            String str = sbf.toString();
            byte[] b=str.getBytes();
            for(int i=0;i<b.length;i++){
                out.write(b[i]);//������д�뱾���ļ�
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(out!=null)
                    out.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }

    }
}

