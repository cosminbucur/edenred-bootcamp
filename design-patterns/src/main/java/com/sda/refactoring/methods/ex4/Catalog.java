package com.sda.refactoring.methods.ex4;

public class Catalog {

    boolean hasDiscount(Order order) {
        // TODO: refactor > inline variable
        double basePrice = order.basePrice();
        return basePrice > 1000;
    }
}
