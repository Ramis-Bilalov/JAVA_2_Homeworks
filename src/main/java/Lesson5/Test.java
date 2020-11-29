package Lesson5;


import java.util.Arrays;

public class Test {
    static class MyThread extends Thread {

    }

    static final int SIZE = 10_000_000;
    static final int HALF = SIZE/2;
    private static final float[] arr = new float[SIZE];
    private static final float[] a1 = new float[HALF];
    private static final float[] a2 = new float[HALF];

    public static float[] getA1() {
        return a1;
    }

    public static float[] getA2() {
        return a2;
    }

    public static void calculateTime() {
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();
        System.out.println("1. Время выполнения без разбивки массива = " + (b-a) + " миллисекунд");
    }

    public static void breakUpArray() {

        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, 5_000_000);
        System.arraycopy(arr, HALF, a2, 0, 5_000_000);


        Runnable newValueFirstHalf = () -> {
            for (int i = 0; i < HALF; i++) {
                a1[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        };

        Runnable newValueSecondHalf = () -> {
            for (int i = 0; i < HALF; i++) {
                a2[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        };

        Thread t1 = new Thread(newValueFirstHalf);
        Thread t2 = new Thread(newValueSecondHalf);
        t1.start();
        t2.start();

        System.arraycopy(a1, 0, arr, 0, 5_000_000);
        System.arraycopy(a2, 0, arr, 5_000_000, 5_000_000);

        long b = System.currentTimeMillis();
        System.out.println("2. Время выполнения при разбивке массива = " + (b-a) + " миллисекунд");

    }

    public static void main(String[] args) {
        calculateTime();
        breakUpArray();
    }
}
