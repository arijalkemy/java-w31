package com.bootcamp;

public class CarRescuer implements IRescuer<Car> {
    public CarRescuer() {}

    public void rescue(Car car) {
        System.out.println("\nRescuing car: " + car.getPatent());
    }
}
