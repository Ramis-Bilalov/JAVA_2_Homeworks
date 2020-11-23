package Lesson2.homework;

public class MyArrayDataException extends Exception{
    private int detail;

    public MyArrayDataException(int detail, String message) {
        super(message);
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "MyArrayDataException {"
                + " detail = " + detail
                + ", message = " + getMessage()
                + " }";
    }
}
