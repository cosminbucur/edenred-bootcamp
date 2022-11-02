package com.sda.refactoring.methods.ex5;

public class Calculator {

    private double quantity;
    private double itemPrice;

    double calculateTotal() {
        double basePrice = quantity * itemPrice;
        if (basePrice > 1000) {
            return basePrice * 0.95;
        } else {
            return basePrice * 0.98;
        }
    }
}
