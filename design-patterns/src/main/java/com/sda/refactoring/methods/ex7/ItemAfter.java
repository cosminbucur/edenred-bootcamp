package com.sda.refactoring.methods.ex7;

public class ItemAfter {

    int discount(int inputVal, int quantity) {
        int result = inputVal;
        if (quantity > 50) {
            result -= 2;
        }
        // ...
        return result;
    }
}
