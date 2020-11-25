package Lesson3;

import com.sun.source.tree.Tree;

import java.util.Collection;
import java.util.HashMap;
import java.util.TreeSet;

public class PhoneNumbers {

    private HashMap<String, TreeSet<String>> telephoneBook;
    private String name;
    private String number;


    public PhoneNumbers() {
        telephoneBook = new HashMap<>();
    }


    public void addNumber(String name, String number) {
        this.name = name;
        this.number = number;
        if(!telephoneBook.containsKey(name)) {
            telephoneBook.put(name, new TreeSet<>());
        }
        telephoneBook.get(name).add(number);
    }

    public Collection<String> getNumbers(String name) {
        return telephoneBook.get(name);
    }
}