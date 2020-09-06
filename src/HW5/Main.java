package HW5;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10000000;
    static final int H = SIZE / 2;

    public static void main(String[] args) throws InterruptedException {
        float[] arr = new float[SIZE];
        fillArrWithOne(arr);
        checkTime1(arr);
        fillArrWithOne(arr);
        checkTime2(arr);
    }

    public static void fillArrWithOne(float[] arr) {
        Arrays.fill(arr, 1);
    }

    public static void checkTime1(float[] arr) {
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();
        System.out.println("Время работы метода: " + (b - a) + "ms");
    }

    public static void checkTime2(float[] arr) throws InterruptedException {
        float[] arr1 = new float[H];
        float[] arr2 = new float[H];
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, H);
        System.arraycopy(arr, H, arr2, 0, H);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + (i + H) / 5) * Math.cos(0.2f + (i + H) / 5) * Math.cos(0.4f + (i + H) / 2));
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.arraycopy(arr1, 0, arr, 0, H);
        System.arraycopy(arr2, 0, arr, H, H);
        long b = System.currentTimeMillis();
        System.out.println("Время работы метода 2: " + (b - a) + "ms");
    }
}

