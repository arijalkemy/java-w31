package dev.michell;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Garaje garaje = new Garaje(1);

        garaje.addVehiculo(new Vehiculo("Ford", "Fiesta", 1000D))
                .addVehiculo(new Vehiculo("Ford", "Focus", 1200D))
                .addVehiculo(new Vehiculo("Ford", "Explorer", 2500D))
                .addVehiculo(new Vehiculo("Fiat", "Uno", 500D))
                .addVehiculo(new Vehiculo("Fiat", "Cronos", 1000D))
                .addVehiculo(new Vehiculo("Fiat", "Torino", 1250D))
                .addVehiculo(new Vehiculo("Chevrolet", "Aveo", 1250D))
                .addVehiculo(new Vehiculo("Chevrolet", "Spin", 2500D))
                .addVehiculo(new Vehiculo("Toyota", "Corola", 1200D))
                .addVehiculo(new Vehiculo("Toyota", "Fortuner", 3000D))
                .addVehiculo(new Vehiculo("Renault", "Logan", 950D));


        System.out.println("============== VEHICULOS ORDENADOS POR PRECIO ==============");
        garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getCosto));
        garaje.imprimirVehiculos();

        System.out.println("============== VEHICULOS ORDENADOS POR MARCA Y PRECIO ==============");
        garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca)
                .thenComparing(Vehiculo::getCosto));
        garaje.imprimirVehiculos();

        System.out.println("============== VEHICULOS DE PRECIOS < 1000 ==============");
        ArrayList<Vehiculo> vehiculosCostoMenor = garaje.getVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .collect(Collectors.toCollection(ArrayList::new));
        vehiculosCostoMenor.forEach(System.out::println);

        System.out.println("============== VEHICULOS DE PRECIOS >= 1000 =============");
        ArrayList<Vehiculo> vehiculosCostoMayor = garaje.getVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .collect(Collectors.toCollection(ArrayList::new));
        vehiculosCostoMayor.forEach(System.out::println);

        Double promedio = garaje.getVehiculos()
                .stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .getAsDouble();

        System.out.println("Promedio total de Costos: " + promedio);



    }
}
