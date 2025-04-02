package com.mercadolibre.bootcamp;

import com.mercadolibre.bootcamp.model.Garaje;
import com.mercadolibre.bootcamp.model.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje();

        garaje.addVehiculo(new Vehiculo("Ford", "Fiesta", 1000));
        garaje.addVehiculo(new Vehiculo("Ford", "Focus", 1200));
        garaje.addVehiculo(new Vehiculo("Ford", "Explorer", 2500));
        garaje.addVehiculo(new Vehiculo("Fiat", "Uno", 500));
        garaje.addVehiculo(new Vehiculo("Fiat", "Cronos", 1000));
        garaje.addVehiculo(new Vehiculo("Fiat", "Torino", 1250));
        garaje.addVehiculo(new Vehiculo("Chevrolet", "Aveo", 1250));
        garaje.addVehiculo(new Vehiculo("Chevrolet", "Spin", 2500));
        garaje.addVehiculo(new Vehiculo("Toyota", "Corola", 1200));
        garaje.addVehiculo(new Vehiculo("Toyota", "Fortuner", 3000));
        garaje.addVehiculo(new Vehiculo("Renault", "Logan", 950));

        System.out.println("============== Vehiculos en el garaje " + garaje.getId() + " ============");
        garaje.mostrarVehiculos();

        List<Vehiculo> vehiculos = garaje.getVehiculos();
        System.out.println("");
        System.out.println("========= Ordenar Por Precio ==========");
        garaje.getVehiculos().sort((v1, v2) -> v1.getCosto().compareTo(v2.getCosto()));
        garaje.mostrarVehiculos();

        System.out.println("");
        System.out.println("========= Ordenar Por Marca y Precio ==========");
        garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
        garaje.mostrarVehiculos();

        System.out.println("");
        System.out.println("========= Vehículos con precio no mayor a 1000 ==========");
        List<Vehiculo> vehiculosEconomicos = garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .collect(Collectors.toList());
        vehiculosEconomicos.forEach(System.out::println);

        System.out.println("");
        System.out.println("========= Vehículos precio mayor o igual a 1000 ==========");
        List<Vehiculo> vehiculosCostosos = garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .collect(Collectors.toList());
        vehiculosCostosos.forEach(System.out::println);
        
        System.out.println("");
        System.out.println("========= Promedio Garaje ==========");
        Double promedio =  garaje.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average().orElse(0);
        System.out.println(promedio);




    }
}