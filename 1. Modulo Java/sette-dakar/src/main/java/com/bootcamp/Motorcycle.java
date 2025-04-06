package com.bootcamp;

public class Motorcycle extends Vehicle {
    public Motorcycle(Double speed, Double acceleration, Double turningAngle, String patent) {
        super(speed, acceleration, turningAngle, patent, 300.0, 2);
        System.out.println("\nMotorcycle created");
    }

    @Override
    public String toString() {
        return "\nMotorcycle:"+ super.toString();
    }
}
