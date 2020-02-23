package com.gmail.merikbest2015.JavaOOP.homework.lec08.genericscollection.practice.prac01;

public class Main {
    public static void main(String[] args) {
        SomeClass<Integer> someClass = new SomeClass<Integer>(1234);
        SomeClass<String> someClass1 = new SomeClass<>("Hello world");

        //Min element in Integer array
        Integer[] integers = new Integer[]{4, 2, 4, 7, 9};
        int min = findMin(integers);
        System.out.println(min);

        //Min element in String array
        String[] strings = new String[]{"Hello", "A", "B", "World"};
        String minString = findMin(strings);
        System.out.println(minString);

        //Error cant compare Scanner
//        Scanner[] scanners = new Scanner[]{new Scanner(System.in), new Scanner(System.in)};
//        findMin(scanners);

    }

    //Min element in array
    public static <T extends Comparable<T>> T findMin(T[] array) {
        T min = array[0];
        for (T element : array) {
            if (min.compareTo(element) > 0) {
                min = element;
            }
        }
        return min;
    }


}
