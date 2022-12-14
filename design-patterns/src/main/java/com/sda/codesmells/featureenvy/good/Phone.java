package com.sda.codesmells.featureenvy.good;

public class Phone {
    private final String unformattedNumber;

    public Phone(String unformattedNumber) {
        this.unformattedNumber = unformattedNumber;
    }

    private String getAreaCode() {
        return unformattedNumber.substring(0, 3);
    }

    private String getNumber() {
        return unformattedNumber.substring(6, 10);
    }

    public String toFormattedString() {
        return "(" + getAreaCode() + ") " + getNumber();
    }
}