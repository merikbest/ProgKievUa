package com.gmail.merikbest2015.JavaPRO.lec01.reflection.homework.hw01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Solution {
    @TestOne(a = 2, b = 5)
    public static int test(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class<?> cls = Solution.class;
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(TestOne.class)) {
                TestOne testOne = method.getAnnotation(TestOne.class);
                int result = (Integer) method.invoke(null, testOne.a(), testOne.b());
                System.out.println(result);
            }
        }
    }
}