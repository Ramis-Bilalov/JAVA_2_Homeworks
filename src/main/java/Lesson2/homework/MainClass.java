package Lesson2.homework;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        String[][] array = new String[3][4];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = String.valueOf(i + j);
            }
        }

        try {
            sumOfStringToIntArray(array);
            checkStringCharOfElement(array);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Перехваченное исключение " + e);
        }

    }

    private static void checkStringCharOfElement(String[][] array) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(array[i][j]);
                } catch(NumberFormatException | NullPointerException e) {
                    throw new MyArrayDataException(sum, "Элемент массива не содержит цифр");
                }
            }
        } System.out.println("Исключений MyArrayDataException не возникло");
        System.out.println("Сумма равна = " + sum);
    }

    public static void sumOfStringToIntArray(String[][] array) throws MyArraySizeException {
        if(array.length > 4) {
            throw new MyArraySizeException(array.length, "Размер массива больше");
        } else if(array.length < 4) {
            throw new MyArraySizeException(array.length, "Размер массива меньше");
        }
        System.out.println("Исключений MyArraySizeException не возникло");
    }
}