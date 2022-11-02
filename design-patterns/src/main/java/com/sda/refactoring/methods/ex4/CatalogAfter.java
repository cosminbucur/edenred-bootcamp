package com.sda.refactoring.methods.ex4;

public class CatalogAfter {

    boolean hasDiscount(Order order) {
        double basePrice = order.basePrice();
        return basePrice > 1000;
    }
}
