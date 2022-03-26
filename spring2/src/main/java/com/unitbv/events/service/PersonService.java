package com.unitbv.events.service;

import com.unitbv.events.event.CarForRentEvent;
import com.unitbv.events.model.Car;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;

    public PersonService() {
    }

    public void rentCar(String model) {
        final Car car = new Car(model);
        //create a new event and publish car on event
        CarForRentEvent carForRentEvent = new CarForRentEvent(this, car);
        eventPublisher.publishEvent(carForRentEvent);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher =applicationEventPublisher;
    }
}
