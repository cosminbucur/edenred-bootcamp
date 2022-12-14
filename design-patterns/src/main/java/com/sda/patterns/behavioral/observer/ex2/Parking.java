package com.sda.patterns.behavioral.observer.ex2;

import java.util.ArrayList;
import java.util.List;

// subject
public class Parking {

    private List<Car> cars = new ArrayList<>();
    private List<CarAddedListener> listeners = new ArrayList<>();

    public void addCar(Car car) {
        // add the car to the list of cars
        this.cars.add(car);

        // notify the list of registered listeners
        this.notify(car);
    }

    public void register(CarAddedListener listener) {
        // add the listener to the list of registered listeners
        this.listeners.add(listener);
    }

    public void unregister(CarAddedListener listener) {
        // remove the listener from the list of the registered listeners
        this.listeners.remove(listener);
    }

    protected void notify(Car car) {
        // notify each of the listeners in the list of registered listeners
        this.listeners.forEach(listener -> listener.onCarAdded(car));
    }
}
