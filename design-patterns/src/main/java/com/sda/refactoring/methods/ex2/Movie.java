package com.sda.refactoring.methods.ex2;

public class Movie implements InlineMethod {

    private int commentCount;

    @Override
    public void spendBonus() {
        System.out.println("buy car");
    }

    @Override
    public int getRating() {
        return moreThanTenComments() ? 5 : 1;
    }

    private boolean moreThanTenComments() {
        return commentCount > 10;
    }
}
