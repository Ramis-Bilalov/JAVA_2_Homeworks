package Lesson6.classwork;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable, Closeable {

    private static int cnt = 0;
    private final int connectionId;
    private final Socket socket;
    private final DataInputStream is;
    private final DataOutputStream os;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        is = new DataInputStream(socket.getInputStream());
        os = new DataOutputStream(socket.getOutputStream());
        cnt++;
        connectionId = cnt;
    }

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        while(true) {
            try {
                String messageFromServer = in.nextLine();
                os.writeUTF(messageFromServer);
                System.out.println(is.readUTF());
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void close() throws IOException {
        os.close();
        is.close();
    }
}
