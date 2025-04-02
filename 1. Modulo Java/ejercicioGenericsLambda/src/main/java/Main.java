package main.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Fiesta", "Ford", 1000.0));
        vehiculos.add(new Vehiculo("Focus", "Ford", 1200.0));
        vehiculos.add(new Vehiculo("Explorer", "Ford", 2500.0));
        vehiculos.add(new Vehiculo("Uno", "Fiat", 500.0));
        vehiculos.add(new Vehiculo("Cronos", "Fiat", 1000.0));
        vehiculos.add(new Vehiculo("Torino", "Fiat", 1250.0));
        vehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250.0));
        vehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500.0));
        vehiculos.add(new Vehiculo("Corola", "Toyota", 1200.0));
        vehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000.0));
        vehiculos.add(new Vehiculo("Logan", "Renault", 950.0));

        Garaje garaje = new Garaje(1, vehiculos);

        vehiculos.stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).forEach(x -> System.out.println(x.getCosto()));

        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(x -> System.out.println(x.getMarca() + " " + x.getCosto()));

        System.out.println("Ejecicio 5:");
        List<Vehiculo> lista1 = vehiculos.stream().filter(x -> x.getCosto() < 1000.0).collect(Collectors.toList());
        List<Vehiculo> lista2 = vehiculos.stream().filter(x -> x.getCosto() >= 1000.0).collect(Collectors.toList());
        Double promedioCosto = vehiculos.stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();

        lista1.forEach(x -> System.out.println(x.getCosto()));
        System.out.println();
        lista2.forEach(x -> System.out.println(x.getCosto()));
        System.out.println();
        System.out.println(promedioCosto);
    }
}
