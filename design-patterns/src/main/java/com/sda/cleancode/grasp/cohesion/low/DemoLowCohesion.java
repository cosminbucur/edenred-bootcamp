package com.sda.cleancode.grasp.cohesion.low;

public class DemoLowCohesion {

    public static void main(String[] args) {
        DownloadAndStore downloadAndStore = new DownloadAndStore();
        downloadAndStore.doEverything();
    }
}
