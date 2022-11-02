package com.sda.refactoring.methods.ex3;

public class MenuAfter {

    private int resize;
    private String platform;
    private String browser;

    void renderBanner() {

        boolean isLinux = platform.toUpperCase().contains("LINUX");
        boolean isFirefox = browser.toUpperCase().contains("FIREFOX");
        boolean wasResized = resize > 0;

        if (isLinux && isFirefox && wasInitialized() && wasResized) {
            System.out.println("display logo");
        }
    }

    private boolean wasInitialized() {
        return false;
    }
}
