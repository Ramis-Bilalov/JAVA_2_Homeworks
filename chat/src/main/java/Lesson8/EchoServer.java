package Lesson8;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentLinkedDeque;

public class EchoServer {

    private boolean running;
    private ConcurrentLinkedDeque<SerialHandler> clients = new ConcurrentLinkedDeque<>();

    public EchoServer() {
        // web 8080
        running = true;
        try(ServerSocket server = new ServerSocket(8189)) {
            System.out.println("Server started!");
            while (running) {
                System.out.println("Server is waiting connection");
                Socket socket = server.accept();
                System.out.println("Client accepted!");
                SerialHandler handler = new SerialHandler(socket, this);
                clients.add(handler);
                new Thread(handler).start();
                System.out.println("Client info: " + socket.getInetAddress());
            }
        } catch (Exception e) {
            System.out.println("Server crashed");
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void broadCast(Message msg) throws IOException {
        for (SerialHandler client : clients) {
            client.sendMessage(msg);
        }
    }

    public void sendMessageTo(String from, String nick, String message) throws IOException {
        for (SerialHandler client : clients) {
            if (client.getUserName().equals(nick)) {
                client.sendMessage(Message.of(from, message));
            }
        }
    }

    public void kickMe(SerialHandler client) {
        clients.remove(client);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException {
        new EchoServer();
    }
}