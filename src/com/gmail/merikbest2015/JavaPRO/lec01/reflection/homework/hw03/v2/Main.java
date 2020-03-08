package com.gmail.merikbest2015.JavaPRO.lec01.reflection.homework.hw03.v2;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        Test test = new Test();
        test.setA(7);
        test.setB("Hello world");

        String result = Serializer.serialize(test);
        System.out.println("Serialized " + result);

        test = Serializer.deserialize(result,Test.class);
        System.out.println("Deserialized " + test.getA() + ", " + test.getB() + ", " + test.getC());
    }
}