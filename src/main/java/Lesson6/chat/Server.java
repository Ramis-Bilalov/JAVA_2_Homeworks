package Lesson6.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static ClientHandler handler;

    public static void main(String[] args) throws IOException {
        Thread writeThread = new Thread(() -> {                      // поток записи
            try {
                Scanner in = new Scanner(System.in);
                while(in.hasNextLine()) {
                    String message = in.nextLine();
                    if(handler.isRunning()) {
                        handler.sendMessage(message);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        writeThread.setDaemon(true);
        writeThread.start();
        try (ServerSocket serverSocket = new ServerSocket(8180)) {
            while(true) {
                Socket socket = serverSocket.accept();
                handler = new ClientHandler(socket);
                new Thread(handler).start();                            // поток чтения
            }
        }
    }
}
