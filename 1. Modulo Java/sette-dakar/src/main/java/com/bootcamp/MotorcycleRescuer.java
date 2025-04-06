package com.bootcamp;

public class MotorcycleRescuer implements IRescuer<Motorcycle> {
    public MotorcycleRescuer() {
    }

    public void rescue(Motorcycle motorcycle) {
        System.out.println("\nRescuing motorcycle: " + motorcycle.getPatent());
    }
}
