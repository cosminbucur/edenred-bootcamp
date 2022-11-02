package com.sda.refactoring.methods.ex5;

public class CalculatorAfter {

    private double quantity;
    private double itemPrice;

    double calculateTotal() {
        double basePrice = getBasePrice();
        if (basePrice > 1000) {
            return basePrice * 0.95;
        } else {
            return basePrice * 0.98;
        }
    }

    private double getBasePrice() {
        return quantity * itemPrice;
    }
}
