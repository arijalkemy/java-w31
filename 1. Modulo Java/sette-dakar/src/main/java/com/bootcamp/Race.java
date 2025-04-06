package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private Double distance;
    private Double prizeUSD;
    private String name;
    private Integer amountOfVehiclesAllowed;
    private List<Vehicle> vehicles;
    private MotorcycleRescuer motorcycleRescuer;
    private CarRescuer carRescuer;

    public Race(Double distance, Double prizeUSD, String name, Integer amountOfVehiclesAllowed) {
        this.distance = distance;
        this.prizeUSD = prizeUSD;
        this.name = name;
        this.amountOfVehiclesAllowed = amountOfVehiclesAllowed;
        this.vehicles = new ArrayList<>();
        this.motorcycleRescuer = new MotorcycleRescuer();
        System.out.println("\nRace created");
    }

    public Double getDistance() {
        return distance;
    }

    public Double getPrizeUSD() {
        return prizeUSD;
    }

    public String getName() {
        return name;
    }

    public Integer getAmountOfVehiclesAllowed() {
        return amountOfVehiclesAllowed;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addCar(Double speed, Double acceleration, Double turningAngle, String patent) {
        System.out.println("\nAdding Car to the race");
        if (vehicles.size() <= amountOfVehiclesAllowed) {
            vehicles.add(new Car(speed, acceleration, turningAngle, patent));
        }
    }

    public void addMotorcycle(Double speed, Double acceleration, Double turningAngle, String patent) {
        System.out.println("\nAdding Motorcycle to the race");
        if (vehicles.size() <= amountOfVehiclesAllowed) {
            vehicles.add(new Motorcycle(speed, acceleration, turningAngle, patent));
        }
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public void removeVehicleWithPatent(String patent) {
        vehicles.removeIf(vehicle -> vehicle.getPatent().equals(patent));
    }

    public Vehicle selectWinner(List<Vehicle> vehicles) {
        System.out.println("\nChoosing winner");
        Vehicle winner = vehicles.getFirst();
        double highestValue = winner.getSpeed() * (0.5) * winner.getAcceleration() / (winner.getTurningAngle() * (winner.getWeight() - winner.getWheels() * 100));

        for (Vehicle vehicle : vehicles) {
            double vehicleValue = vehicle.getSpeed() * (0.5) * vehicle.getAcceleration() / (vehicle.getTurningAngle() * (vehicle.getWeight() - vehicle.getWheels() * 100));
            if (vehicleValue > highestValue) {
                highestValue = vehicleValue;
                winner = vehicle;
            }
        }
        return winner;
    }

    public void rescueCar(String patent) {
        carRescuer.rescue((Car) getVehicleWithPatent(patent));
    }

    public void rescueMotorcycle(String patent) {
        motorcycleRescuer.rescue((Motorcycle) getVehicleWithPatent(patent));
    }

    public Vehicle getVehicleWithPatent(String patent) {
        System.out.println("\nShowing vehicle with patent: " + patent);
        Vehicle resultingVehicle = null;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPatent().equals(patent)) {
                resultingVehicle = vehicle;
            }
        }
        return resultingVehicle;
    }
    @Override
    public String toString() {
        return "\n\tRace:" +
                "\ndistance= " + distance +
                "\nprizeUSD= $" + prizeUSD +
                "\nname= " + name +
                "\namount Of Vehicles Allowed= " + amountOfVehiclesAllowed +
                "\nvehicles= " + vehicles;
    }
}
