package com.bootcamp;

public class Car extends Vehicle {
    public Car(Double speed, Double acceleration, Double turningAngle, String patent) {
        super(speed, acceleration, turningAngle, patent, 1000.0, 4);
        System.out.println("\nCar created");
    }

    @Override
    public String toString() {
        return "\nCar: "+ super.toString();
    }
}
