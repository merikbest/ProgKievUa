package com.gmail.merikbest2015.JavaOOP.homework.lec04.MutableImmutable;

public class Main {
    public static void main(String[] args) {
        MutablePoint mutablePoint = new MutablePoint(0, 0);
        long tStart = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
//            double x = Math.random() * 10;
            mutablePoint.setX(1);
        }

        long tEnd = System.currentTimeMillis();

        System.out.println((tEnd - tStart) + " ms");

        ImmutablePoint imMutablePoint = new ImmutablePoint(0, 0);
        long tStartIm = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
//            double x = Math.random() * 10;
            imMutablePoint = imMutablePoint.setX(1);
        }

        long tEndIm = System.currentTimeMillis();

        System.out.println((tEndIm - tStartIm) + " ms");




/*
        ImmutablePoint immutablePoint = new ImmutablePoint(0,0);
        ImmutablePoint immutablePoint2 = immutablePoint;

        immutablePoint2 = immutablePoint2.setX(5);
        System.out.println(immutablePoint);
        System.out.println(immutablePoint2);
*/




/*        MutablePoint point1 = new MutablePoint(0, 0);
        MutablePoint point2 = new MutablePoint(1, 1);
        MutablePoint point3 = new MutablePoint(3, 3);

        MutablePoint[] points = new MutablePoint[]{point1, point2, point3};

        for (MutablePoint mutablePoint : points) {
            System.out.println(mutablePoint);
        }

        MutablePoint[] pointsCopy = Arrays.copyOf(points, points.length);

        System.out.println();

        for (MutablePoint mutablePoint : pointsCopy) {
            System.out.println(mutablePoint);
        }

        points[0].setX(5);

        System.out.println("\n" + "After" + "\n");

        for (MutablePoint mutablePoint : pointsCopy) {
            System.out.println(mutablePoint);
        }

        ImmutablePoint immutablePoint1 = new ImmutablePoint(0, 0);
        ImmutablePoint immutablePoint2 = new ImmutablePoint(1, 1);
        ImmutablePoint immutablePoint3 = new ImmutablePoint(3, 3);

        ImmutablePoint[] immutablePoints = new ImmutablePoint[]{immutablePoint1, immutablePoint2, immutablePoint3};

        System.out.println("\n" + "Immutable" + "\n");

        for (ImmutablePoint immutablePoint : immutablePoints) {
            System.out.println(immutablePoint);
        }

        ImmutablePoint[] immutablePoints2 = Arrays.copyOf(immutablePoints, immutablePoints.length);

//        immutablePoints[0] = new ImmutablePoint(6, 6);
        immutablePoints[0].setX(5);

        System.out.println("\n" + "After" + "\n");

        for (ImmutablePoint immutablePoint : immutablePoints2) {
            System.out.println(immutablePoint);
        }*/
    }
}
