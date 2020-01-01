package dome.消息转发;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        Thread t = new Thread(new chat());
        t.start();
    }
}

class chat implements Runnable{
    @Override
    public void run() {

            try {
                ServerSocket ss = new ServerSocket(9527);
                Socket s = ss.accept();
                Scanner scan = new Scanner(System.in);
                while (true) {
                    ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                    System.out.println(ois.readObject());

                    System.out.print(">>>");
                    String str = scan.next();

                    ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                    oos.writeObject(str);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }


    }
}
