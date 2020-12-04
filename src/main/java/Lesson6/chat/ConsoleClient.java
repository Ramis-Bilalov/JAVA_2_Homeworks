package Lesson6.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8180);
            DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            Thread readThread = new Thread (() -> {                                 // создаем поток чтения
                try {
                    while(true){
                        System.out.println("Сервер: " + is.readUTF());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            Thread writeThread = new Thread (() -> {                                // создаем поток записи
                try {
                    Scanner in = new Scanner(System.in);
                    while(in.hasNextLine()) {
                        String msg = in.nextLine();
                        os.writeUTF(msg);
                        os.flush();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            writeThread.setDaemon(true);
            writeThread.start();
            readThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
