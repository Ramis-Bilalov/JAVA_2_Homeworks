package Lesson8;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SerialHandler implements Closeable, Runnable {

    private static int cnt = 0;
    private String userName;
    private final ObjectInputStream is;
    private final ObjectOutputStream os;
    private boolean running;
    private final byte [] buffer;
    private final EchoServer server;
    private ChatController chatController;


    public SerialHandler(Socket socket, EchoServer server) throws IOException {
        System.out.println("1");
        os = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("2");
        is = new ObjectInputStream(socket.getInputStream());
        System.out.println("3");
        cnt++;
        userName = "username" + cnt;
        running = true;
        buffer = new byte[256];
        this.server = server;
        os.writeObject(Message.of(userName, "OK"));
        os.flush();
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        while (running) {
            try {
                try {
                    UsersSQLiteDao userDao = new UsersSQLiteDao();
                    userName = userDao.getNickname();
                } catch (NullPointerException | SQLException s) {
                    s.printStackTrace();
                }
                Message message = (Message) is.readObject();

                if (message.getMessage().startsWith("/changeNick")) {
                    String[] data = message.getMessage().split(" ");
                    String oldName = userName;
                    userName = data[1];
                    String msg = String.format("User %s change name to %s", oldName, userName);
                    sendMessage(Message.of(userName, msg));
                    continue;
                }
                if (message.getMessage().startsWith("/private")) {
                    String[] data = message.getMessage().split(" ");
                    String nick = data[1];
                    String msg = data[2];
                    sendMessage(message);
                    server.sendMessageTo(userName, nick, msg);
                    continue;
                }
                message.setAuthor(userName);
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

    public String getUserName() {
        return userName;
    }

    @Override
    public void close() throws IOException {
        os.close();
        is.close();
    }
}