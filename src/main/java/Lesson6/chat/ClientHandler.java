package Lesson6.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{

    DataInputStream is;
    DataOutputStream os;
    private boolean isRunning;

    public ClientHandler(Socket socket) throws IOException {
        is = new DataInputStream(socket.getInputStream());
        os = new DataOutputStream(socket.getOutputStream());
        isRunning = true;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void sendMessage(String message) throws IOException {
        os.writeUTF(message);
        os.flush();
    }

    @Override
    public void run() {
        while(isRunning) {
            try {
                System.out.println("Клиент: " + is.readUTF());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
