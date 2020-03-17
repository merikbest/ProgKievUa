package com.gmail.merikbest2015.JavaPRO.lec01.reflection.homework.hw02;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SaveTo {
    String path();
}