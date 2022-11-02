package com.sda.codesmells.featureenvy.bad;

public class Phone {

    private final String unformattedNumber;

    public Phone(String unformattedNumber) {
        this.unformattedNumber = unformattedNumber;
    }

    public String getAreaCode() {
        return unformattedNumber.substring(0, 3);
    }

    public String getNumber() {
        return unformattedNumber.substring(6, 10);
    }
}