package Lesson1.classwork1;

public class User {
    private String name;
    private String surname;

    private User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public static User of(String name, String surname) {
        return new User(name, surname);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
