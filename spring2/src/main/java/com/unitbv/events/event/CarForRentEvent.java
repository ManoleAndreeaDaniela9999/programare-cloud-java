package com.unitbv.events.event;

import com.unitbv.events.model.Car;
import org.springframework.context.ApplicationEvent;

public class CarForRentEvent extends ApplicationEvent {

    Car carForRent;
    public CarForRentEvent(Object source, Car car) {
        super(source);
        this.carForRent = car;
    }

    public Car getCarForRent() {
        return carForRent;
    }
}
