package org.vehiculo;


import org.vehiculo.clases.Garaje;
import org.vehiculo.clases.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculosList = new ArrayList<>();

        // Agregar vehículos a la lista
        vehiculosList.add(new Vehiculo("Fiesta", 1000, "Ford"));
        vehiculosList.add(new Vehiculo("Focus", 1200, "Ford"));
        vehiculosList.add(new Vehiculo("Explorer", 2500, "Ford"));
        vehiculosList.add(new Vehiculo("Uno", 500, "Fiat"));
        vehiculosList.add(new Vehiculo("Cronos", 1000, "Fiat"));
        vehiculosList.add(new Vehiculo("Torino", 1250, "Fiat"));
        vehiculosList.add(new Vehiculo("Aveo", 1250, "Chevrolet"));
        vehiculosList.add(new Vehiculo("Spin", 2500, "Chevrolet"));
        vehiculosList.add(new Vehiculo("Corola", 1200, "Toyota"));
        vehiculosList.add(new Vehiculo("Fortuner", 3000, "Toyota"));
        vehiculosList.add(new Vehiculo("Logan", 950, "Renault"));

        Garaje garaje = new Garaje(1, vehiculosList);

        // Ej 3: Haciendo uso del
        // método sort en la lista de Vehículos con expresiones
        //  lambda, obtén una lista de vehículos ordenados por
        //  precio de menor a mayor, imprime por pantalla el resultado.
        garaje.getVehiculosList().stream()
                .sorted(Comparator.comparingInt(Vehiculo::getPrecio)) // Ordenar por precio
                .forEach(vehiculo -> System.out.println("Marca: " + vehiculo.getMarca() + ", Modelo: " +
                        vehiculo.getModelo() + ", Precio: " + vehiculo.getPrecio()));

        System.out.println("------------------------------------------------------------");

        // ej 4 De la misma forma que el ejercicio anterior, imprime una lista ordenada por marca y a su vez por precio.
        garaje.getVehiculosList().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getPrecio))
                .forEach(vehiculo -> System.out.println("Marca: " + vehiculo.getMarca() + ", Modelo: " +
                        vehiculo.getModelo() + ", Precio: " + vehiculo.getPrecio()));

        System.out.println("------------------------------------------------------------");


        System.out.println("Vehiculos menos de 1000");
        garaje.getVehiculosList().stream()
                .filter(vehiculo -> vehiculo.getPrecio() < 1000)
                .sorted(Comparator.comparingInt(Vehiculo::getPrecio)) // Ordenar por precio
                .forEach(vehiculo -> System.out.println("Marca: " + vehiculo.getMarca() + ", Modelo: " +
                        vehiculo.getModelo() + ", Precio: " + vehiculo.getPrecio()));

        System.out.println("-----------------------------------------------------------");

        System.out.println("Vehiculos mayor o igual a 1000");
        garaje.getVehiculosList().stream()
                .filter(vehiculo -> vehiculo.getPrecio() >= 1000)
                .sorted(Comparator.comparingInt(Vehiculo::getPrecio)) // Ordenar por precio
                .forEach(vehiculo -> System.out.println("Marca: " + vehiculo.getMarca() + ", Modelo: " +
                        vehiculo.getModelo() + ", Precio: " + vehiculo.getPrecio()));

        System.out.println("-----------------------------------------------------------");

        double promedio = garaje.getVehiculosList().stream()
                .mapToDouble(Vehiculo::getPrecio)
                .average()
                .orElse(0); // Devuelve 0 si la lista está vacía

        System.out.println("Promedio: " + promedio/garaje.getVehiculosList().size());
    }
}