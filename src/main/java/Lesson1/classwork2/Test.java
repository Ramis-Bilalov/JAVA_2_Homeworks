package Lesson1.classwork2;

import java.io.File;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws Exception {
        FileMessage<String> fileMessage = new FileMessage<>("lol.txt");
        fileMessage.write("Hello World");

        System.out.println(fileMessage.read());
    }
}
