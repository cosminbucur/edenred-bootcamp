package com.sda.refactoring.methods.ex1;

public class Before implements ExtractMethod {

    @Override
    public void printAd(String name) {
        printBanner();

        // print details
        System.out.println("name: " + name);
        System.out.println("amount: " + getAmount());
    }

    private void printBanner() {

    }

    private String getAmount() {
        return null;
    }
}
