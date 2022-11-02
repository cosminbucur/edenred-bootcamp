package com.sda.refactoring.methods.ex3;

public class Menu {

    private int resize;
    private String platform;
    private String browser;

    void renderBanner() {

        if (platform.toUpperCase().contains("LINUX") &&
                browser.toUpperCase().contains("FIREFOX") &&
                wasInitialized() &&
                resize > 0) {

            System.out.println("display logo");
        }
    }

    private boolean wasInitialized() {
        return false;
    }
}
