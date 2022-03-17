package org.example;


public class Triangle {
    public static Object areaOfTriangle(int a, int b, int c) {
        if (a + b < c || a + c < b || b + c < a) {
            return "Стороны не образуют треугольник";
        }
        if (a <= 0 && b <= 0 && c <= 0 ) {
            return "Неверно заданы стороны";
        }

        double p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c)); //Формула Герона

        return s;
    }

}
