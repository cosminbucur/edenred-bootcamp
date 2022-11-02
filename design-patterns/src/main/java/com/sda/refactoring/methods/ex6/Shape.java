package com.sda.refactoring.methods.ex6;

public class Shape {

    private double height;
    private double width;

    public void getArea() {
        double temp = 2 * (height + width);
        System.out.println(temp);

        temp = height * width;
        System.out.println(temp);
    }
}
