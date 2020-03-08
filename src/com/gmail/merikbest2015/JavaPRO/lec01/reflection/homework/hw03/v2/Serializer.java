package com.gmail.merikbest2015.JavaPRO.lec01.reflection.homework.hw03.v2;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.InvalidParameterException;

public class Serializer {
    public static String serialize(Object o) throws IllegalAccessException {
        Class<?> cls = o.getClass();
        StringBuilder sb = new StringBuilder();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAnnotationPresent(Save.class)) {
                continue;
            }
            if (Modifier.isPrivate(field.getModifiers())) {
                field.setAccessible(true);
            }

            sb.append(field.getName() + "=");

            if (field.getType() == int.class) {
                sb.append(field.getInt(o));
            } else if (field.getType() == String.class) {
                sb.append(field.get(o));
            } else if (field.getType() == long.class) {
                sb.append(field.getLong(o));
            }

            sb.append(";");
        }
        return sb.toString();
    }

    public static <T> T deserialize(String s, Class<T> cls) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        T res = (T) cls.newInstance();
        String[] pairs = s.split(";");

        for (String pair : pairs) {
            String[] nv = pair.split("=");
            if (nv.length != 2) {
                throw new InvalidParameterException(s);
            }
            String name = nv[0];
            String value = nv[1];
            Field field = cls.getDeclaredField(name);
            if (Modifier.isPrivate(field.getModifiers())) {
                field.setAccessible(true);
            }
            if (field.isAnnotationPresent(Save.class)) {
                if (field.getType() == int.class) {
                    field.setInt(res, Integer.parseInt(value));
                } else if (field.getType() == String.class) {
                    field.set(res, value);
                } else if (field.getType() == long.class) {
                    field.setLong(res, Long.parseLong(value));
                }
            }
        }
        return res;
    }
}