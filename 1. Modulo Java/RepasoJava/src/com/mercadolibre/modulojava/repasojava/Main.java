package com.mercadolibre.modulojava.repasojava;

import java.util.Comparator;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Garaje garage=new Garaje("1");
        garage.agregarVehiculo(new Vehiculo("Ford", "Fiesta", 1000));
        garage.agregarVehiculo(new Vehiculo("Ford", "Focus", 1200));
        garage.agregarVehiculo(new Vehiculo("Ford", "Explorer", 2500));
        garage.agregarVehiculo(new Vehiculo("Fiat", "Uno", 500));
        garage.agregarVehiculo(new Vehiculo("Fiat", "Cronos", 1000));
        garage.agregarVehiculo(new Vehiculo("Fiat", "Torino", 1250));
        garage.agregarVehiculo(new Vehiculo("Chevrolet", "Aveo", 1250));
        List<Vehiculo> vehiculos=garage.getVehiculos();
                vehiculos.sort(Comparator.comparing(Vehiculo::getCosto));

                vehiculos.forEach(System.out::println);
                vehiculos.sort( Comparator.comparing(Vehiculo::getMarca)
                .thenComparing(Vehiculo::getCosto));
                System.out.println("\n");
                vehiculos.forEach(System.out::println);
                System.out.println();
                vehiculos.stream().filter(vehiculo -> vehiculo.getCosto()<1000).forEach(System.out::println);
                System.out.println();
                vehiculos.stream().filter(vehiculo -> vehiculo.getCosto()>=1000).forEach(System.out::println);
                System.out.println();
                vehiculos.stream().mapToInt(Vehiculo::getCosto).average().ifPresent(System.out::println);


    }
}