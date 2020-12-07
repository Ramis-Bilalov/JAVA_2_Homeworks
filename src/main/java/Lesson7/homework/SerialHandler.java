package Lesson7.homework;

import java.io.*;
import java.net.Socket;

public class SerialHandler implements Closeable, Runnable {
    private static int cnt = 0;
    private final String userName;
    private final ObjectInputStream is;
    private final ObjectOutputStream os;
    private boolean running;
    private final byte[] buffer;
    private final EchoServer server;



    public SerialHandler(Socket socket, EchoServer server) throws IOException {
        os = new ObjectOutputStream(socket.getOutputStream());
        is = new ObjectInputStream(socket.getInputStream());
        cnt++;
        userName = "user#" + cnt;
        running = true;
        buffer = new byte[256];
        this.server = server;

    }


    public String getUserName() {
        return userName;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        while(running) {
            try {
                Message message = (Message) is.readObject();
                System.out.println(message);
                server.broadCast(message);
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Exception while read");
                break;
            }
        }
    }

    public void sendMessage(Message message) throws IOException {
        os.writeObject(message);
        os.flush();
    }

    @Override
    public void close() throws IOException {
        os.close();
        is.close();
    }
}
