import com.sun.corba.se.spi.activation.Server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.rmi.server.ExportException;
import java.util.Scanner;

public class dome1{
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost",7788);
        OutputStream os = s.getOutputStream();
        InputStream is = s.getInputStream();
        byte b[] = new byte[1024];
        int len = is.read(b);
        System.out.println(new String(b,0,len));
        String str = "数据接受";
        os.write(str.getBytes());
    }

}

class server{
    public static void main(String[] args) {
        ServerSocket ss;
        Socket s;
        InputStream is;
        OutputStream os;
        String str;
        try{
            ss = new ServerSocket(9527);
            s = ss.accept();
            is = s.getInputStream();
            os = s.getOutputStream();
            byte b[] = new byte[1024];
            Scanner sc = new Scanner(System.in);
            while (true){
                str = sc.nextLine();
                os.write(str.getBytes());
                int len = is.read(b);
                System.out.println(new String(b,0,len));
            }
        }catch (Exception e){
        }

    }
}

class client{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str;
        Socket s = new Socket("localhost",9527);
        OutputStream os = s.getOutputStream();
        InputStream is = s.getInputStream();
        byte b[] = new byte[1024];
        while (true){
            int len = is.read(b);
            System.out.println(new String(b,0,len));
            str = sc.nextLine();
            os.write(str.getBytes());
        }
    }
}