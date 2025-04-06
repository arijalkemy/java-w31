package com.bootcamp;

public class Main {
    public static void main(String[] args) {
        Race race = new Race(10.0, 20000.0, "Race of the wind", 3);
        race.addCar(300.0, 12.0, 45.0, "Ford123");
        race.addMotorcycle(200.0, 23.0, 34.0, "Aut34");
        race.addMotorcycle(201.0, 20.0, 30.0, "Aut56");
        race.addMotorcycle(200.0, 20.0, 30.0, "Aut78");
        race.rescueMotorcycle(race.getVehicles().get(2).getPatent());
        System.out.println(race.selectWinner(race.getVehicles()));
    }
}