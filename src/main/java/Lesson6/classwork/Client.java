package Lesson6.classwork;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8182);
        DataInputStream is = new DataInputStream(socket.getInputStream());
        DataOutputStream os = new DataOutputStream(socket.getOutputStream());
        while (true) {
            System.out.println(is.readUTF());
            String message = in.nextLine();
            os.writeUTF(message);
        }
    }
}
