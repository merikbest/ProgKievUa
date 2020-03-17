package com.gmail.merikbest2015.JavaOOP.homework.lec03.polymorph.practice.lessont3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = generateArray();
        int[] b = generateArray();
        int[] c = generateArray();
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        System.out.println("Total sum = " + (getArraySum(a) + getArraySum(b) + getArraySum(c)));
        System.out.println("Total sum method = " + (getArraySum(a, b, c)));

    }

    public static int[] generateArray() {
        int[] array = new int[5 + (int) ((Math.random() * 16))];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
        }
        return array;
    }

    public static int getArraySum(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    public static int getArraySum(int[] a, int[] b, int[] c) {
        int sum = 0;
        int stop = 0;

        for (int i = 0; stop != 7; i++) {
            try {
                sum += a[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                if ((stop & 1) == 0) {
                    System.out.println("a");
                    stop = stop | 1;
                }
            }

            try {
                sum += b[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                if ((stop & 2) == 0) {
                    System.out.println("b");
                    stop = stop | 2;
                }
            }

            try {
                sum += c[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                if ((stop & 4) == 0) {
                    System.out.println("c");
                    stop = stop | 4;
                }
            }
        }
        return sum;
    }
}