package com.gmail.merikbest2015.JavaOOP.homework.lec02.inheritance.homework;

public class Desc {
    private Shape[] shapeArray = new Shape[4];

    public void addShape(Shape shape, int index) {
        if (index > 0 && index < 5) {
            if (shapeArray[index - 1] == null) {
                shapeArray[index - 1] = shape;
                System.out.println("В ячейку " + index + " добавлена фигура " + shapeArray[index - 1].getClass().getSimpleName());
            } else {
                System.out.println("Ячейка занята");
            }
        } else {
            System.out.println("Ошибка! Такой ячейки не существует.");
        }
    }

    public void getShapes(int index) {
        if (index > 0 && index < 5) {
            if (shapeArray[index - 1] != null) {
                System.out.println("В ячейке " + index + " находится фигура " + shapeArray[index - 1].getClass().getSimpleName());
            } else {
                System.out.println("В ячейке " + index + " фигуры нет.");
            }
        } else {
            System.out.println("Ошибка! Такой ячейки не существует.");
        }
    }

    public void removeShapes(int index) {
        if (index > 0 && index < 5) {
            if (shapeArray[index - 1] != null) {
                System.out.println("Фигура " + shapeArray[index - 1].getClass().getSimpleName() + " удалена.");
                shapeArray[index - 1] = null;
            } else {
                System.out.println("Под индексом " + index + " фигуры нет.");
            }
        } else {
            System.out.println("Ошибка! Такой ячейки не существует.");
        }
    }
}