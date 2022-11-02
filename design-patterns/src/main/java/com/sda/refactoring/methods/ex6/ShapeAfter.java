package com.sda.refactoring.methods.ex6;

public class ShapeAfter {

    private double height;
    private double width;

    public void getArea() {
        double perimeter = 2 * (height + width);
        System.out.println(perimeter);

        double area = height * width;
        System.out.println(area);
    }
}
