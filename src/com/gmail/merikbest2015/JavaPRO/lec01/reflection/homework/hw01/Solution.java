package com.gmail.merikbest2015.JavaPRO.lec01.reflection.homework.hw01;

import java.lang.reflect.Method;

public class Solution {
    @TestOne(a = 2, b = 5)
    public void test(int a, int b) {
        System.out.println(a + b);
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Solution solution = new Solution();
        Method method = solution.getClass().getMethod("test", int.class, int.class);
        TestOne testOne = method.getAnnotation(TestOne.class);
        solution.test(testOne.a(), testOne.b());
    }
}