package Lesson7.homework;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static int connectionID;
    private static SerialHandler handler;
    private static String name;
    private static Message msgG = new Message();


    public Client(SerialHandler handler) {
        this.handler = handler;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Client.name = name;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8182);
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        System.out.print("Authorize. Enter name: ");
        name = in.nextLine();

        Thread readThread = new Thread(() -> {
            try {
                while(true) {
                    System.out.println(is.readObject());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread writeThread = new Thread(() -> {
            try {
                while(in.hasNextLine()) {
                    String message = in.nextLine();
                    os.writeObject(Message.of(name, message));
                    os.flush();
                }
            } catch (Exception n) {
                n.printStackTrace();
            }
        });
        writeThread.setDaemon(true);
        writeThread.start();
        readThread.start();
    }
}
