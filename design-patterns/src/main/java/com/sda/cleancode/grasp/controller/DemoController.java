package com.sda.cleancode.grasp.controller;

public class DemoController {

    public static void main(String[] args) {
        FrontController frontController = new FrontController();
        frontController.dispatchRequest("STUDENT");
        frontController.dispatchRequest("HOME");
    }
}
