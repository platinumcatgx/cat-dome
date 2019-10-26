package AnLi;

import java.io.*;
import java.net.Socket;

public class Client{
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost",6666);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }
}
