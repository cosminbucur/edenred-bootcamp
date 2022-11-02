package com.sda.patterns.creational.factorymethod.ex1;

public abstract class Car {

    private CarType carType;

    Car(CarType carType) {
        this.carType = carType;
    }

    abstract void build();

    @Override
    public String toString() {
        return "Car{" +
                "carType=" + carType +
                '}';
    }
}
