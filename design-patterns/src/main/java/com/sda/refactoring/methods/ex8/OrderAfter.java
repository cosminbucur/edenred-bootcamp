package com.sda.refactoring.methods.ex8;

public class OrderAfter {

    public double price() {
        return new PriceCalculator(this).compute();
    }
}

class PriceCalculator {

    private double primaryBasePrice;
    private double secondaryBasePrice;
    private double tertiaryBasePrice;

    public PriceCalculator(OrderAfter orderAfter) {
        // copy relevant information from the order
    }

    public double compute() {
        // long computation
        return 0;
    }
}