package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>(Arrays.asList(
                new Vehiculo("Ford", "Fiesta", 1000D),
                new Vehiculo("Ford", "Focus", 1200D),
                new Vehiculo("Ford", "Explorer", 2500D),
                new Vehiculo("Fiat", "Uno", 500D),
                new Vehiculo("Fiat", "Cronos", 1000D),
                new Vehiculo("Fiat", "Torino", 1250D),
                new Vehiculo("Chevrolet", "Aveo", 1250D),
                new Vehiculo("Chevrolet", "Spin", 2500D),
                new Vehiculo("Toyota", "Corolla", 1200D),
                new Vehiculo("Toyota", "Fortuner", 3000D),
                new Vehiculo("Renault", "Logan", 950D)
        ));

        Garaje garaje = new Garaje(100,listaVehiculos);

        //Ordenar por precio

        System.out.println("\nOrdenar por Precio \n");

        //listaVehiculos.sort(Comparator.comparingDouble(Vehiculo::getCosto));
        listaVehiculos.sort(Comparator.comparingDouble(v -> v.getCosto()));

        listaVehiculos.forEach(System.out::println);

        System.out.println("\nOrdenar por Marca y Precio \n");
        listaVehiculos.sort(Comparator
                .comparing(Vehiculo::getMarca)
                .thenComparingDouble(Vehiculo::getCosto)
        );
        listaVehiculos.forEach(System.out::println);

        //Lista de vehiculos no mayor a 1000
        List<Vehiculo> listaVehiculosMenorA1000 = listaVehiculos.stream().filter(v -> v.getCosto()<1000).collect(Collectors.toList());

        System.out.println("\nLista menor a 1000\n");
        listaVehiculosMenorA1000.forEach(System.out::println);

        //Lista de vehiculos mayor o igual a 1000
        List<Vehiculo> listaVehiculosMayorOIgualA1000 = listaVehiculos.stream().filter(v->v.getCosto()>=1000).collect(Collectors.toList());

        System.out.println("\nLista mayor o igual a 1000\n");
        listaVehiculosMayorOIgualA1000.forEach(System.out::println);

        //Promedio
        Double promedioTotal = listaVehiculos.stream().mapToDouble(Vehiculo::getCosto).average().orElse(0D);

        System.out.println("\nPromedio: \n" + promedioTotal);

    }
}
