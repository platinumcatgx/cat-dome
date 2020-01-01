package dome.消息转发;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Thread t = new Thread(new chatClient());
        t.start();
    }
}

class chatClient implements Runnable{
    @Override
    public void run() {
        while (true){
            try {
                Socket s = new Socket("localhost",9527);

                //获取聊天内容
                System.out.print(">>>");
                Scanner scan = new Scanner(System.in);
                String str = scan.next();

                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(str);

                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                System.out.println(ois.readObject());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}