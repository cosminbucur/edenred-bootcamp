package com.sda.refactoring.methods.ex2;

public class After implements InlineMethod {

    private int numberOfLateDeliveries;

    @Override
    public void spendBonus() {
        System.out.println("buy car");
    }

    @Override
    public int getRating() {
        return moreThanFiveLateDeliveries() ? 2 : 1;
    }

    private boolean moreThanFiveLateDeliveries() {
        return numberOfLateDeliveries > 5;
    }
}
