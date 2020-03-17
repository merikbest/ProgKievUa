package com.gmail.merikbest2015.JavaOOP.homework.lec03.polymorph.practice;

public class Main {
    public static void main(String[] args) {
        int[] ints = new int[]{0, 2, 4, 6, 1};
        System.out.println(getElement(ints, 2));
        System.out.println(getElement(ints, 7));
        System.out.println(getCircleArea(5));
    }

    public static int getElement(int[] array, int index) {
        int result = 0;
        try {
            result = array[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index");
        }
//        finally {
//            return result;
//        }
        return result;
    }

    public static double getCircleArea(double r) {
        if (r < 0) {
            throw new IllegalArgumentException("Negative radius");
        }
        return Math.PI * r * r;
    }
}
