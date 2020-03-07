package com.gmail.merikbest2015.JavaPRO.lec01.reflection.homework.hw01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestOne {
    int a();
    int b();
}