package Lesson1.classwork2;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileMessage<T> implements Readable<T>, Writable<T> {

    private FileInputStream in;
    private FileOutputStream out;
    private String path;

    public FileMessage(String path) throws FileNotFoundException {
        this.path = path;
    }
    @SuppressWarnings("unchecked")
    @Override
    public T read() throws Exception {
        File file = new File(path);
        in = new FileInputStream(file);
        String value = new String(in.readAllBytes());
        in.close();
        return (T) value;
    }

    @Override
    public void write(T value) throws Exception{
        File file = new File(path);
        out = new FileOutputStream(file, true);
        out.write(((String)value).getBytes());
        out.close();
    }
}
