package Lesson6.classwork;

import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public EchoServer() {
        try(ServerSocket server = new ServerSocket(8182)) {
//            System.out.println("Server started");
            while(true) {
//                System.out.println("Server is waiting");
                Socket socket = server.accept();
                new Thread(new ClientHandler(socket)).start();
//                System.out.println("Client accepted!");
//                System.out.println("Client Info: " + socket.getInetAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
