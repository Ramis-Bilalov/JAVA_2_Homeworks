package Lesson2.homework;

public class MyArraySizeException extends Exception{
    private int detail;

    public MyArraySizeException(int detail, String message) {
        super(message);
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "MyArraySizeException {"
                + " detail = " + detail
                + ", message = " + getMessage()
                + " }";
    }
}
