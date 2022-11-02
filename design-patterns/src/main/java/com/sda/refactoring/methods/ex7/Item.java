package com.sda.refactoring.methods.ex7;

public class Item {

    int discount(int inputVal, int quantity) {
        if (quantity > 50) {
            inputVal -= 2;
        }
        // ...
        return inputVal + 10;
    }
}
