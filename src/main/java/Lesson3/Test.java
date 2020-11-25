package Lesson3;

public class Test {
    public static void main(String[] args) {
        PhoneNumbers phoneNumbers = new PhoneNumbers();
        phoneNumbers.addNumber("Igor", "89993331212");
        phoneNumbers.addNumber("Kostya", "87771115665");
        phoneNumbers.addNumber("Igor", "81112225478");
        System.out.println(phoneNumbers.getNumbers("Kostya"));
        System.out.println(phoneNumbers.getNumbers("Igor"));

    }
}
