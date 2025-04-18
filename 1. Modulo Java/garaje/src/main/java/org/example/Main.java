package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garaje garaje = new Garaje(1, vehiculos);

        garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getCosto));
        garaje.print();

        System.out.println("------------------------------");

        garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca)
                                            .thenComparing(Vehiculo::getCosto));
        garaje.print();

        System.out.println("-------------------------------");

        garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() < 1000)
                .forEach(v -> System.out.println(v.getMarca() + " - " + v.getCosto()));

        System.out.println("-------------------------------");

        garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() > 1000)
                .forEach(v -> System.out.println(v.getMarca() + " - " + v.getCosto()));

        System.out.println("-------------------------------");

        garaje.getVehiculos().stream()
                .mapToInt(Vehiculo::getCosto)
                .average()
                .ifPresent(System.out::println);
    }
}