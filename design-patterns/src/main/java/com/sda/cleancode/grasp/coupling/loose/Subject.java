package com.sda.cleancode.grasp.coupling.loose;

public class Subject {

    private Topic topic;

    public Subject(Topic topic) {
        this.topic = topic;
    }

    public void startReading() {
        topic.understand();
    }
}
