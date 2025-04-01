package com.mercadolibre;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Garaje {
    private Integer id;
    private LinkedList<Vehiculo> vehiculos;

    public Garaje(Integer id, LinkedList<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LinkedList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(LinkedList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /* Haciendo uso del método sort en la lista de Vehículos con expresiones lambda,
    obtén una lista de vehículos ordenados por precio de menor a mayor, imprime por pantalla el resultado.*/

    public void ordenarPorPrecioDeMenorAMayor(){
        this.vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .map(vehiculo -> "Marca: " + vehiculo.getMarca() + ", Modelo: " + vehiculo.getModelo()  +
                        " - Costo: $" + vehiculo.getCosto())
                .forEach(System.out::println);
    }

    /* De la misma forma que el ejercicio anterior, imprime una lista ordenada por marca y a su vez por precio.*/
    public void ordenarPorMarcaYPrecioMenorAMayor(){
        this.vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .map(vehiculo -> "Marca: " + vehiculo.getMarca() + ", Modelo: " + vehiculo.getModelo()  +
                        " - Costo: $" + vehiculo.getCosto())
                .forEach(System.out::println);
    }

    /* Se desea extraer una lista de vehículos con precio no mayor a 1000, luego otra con precios mayor o
    igual 1000 y por último, obtén el promedio total de precios de toda la lista de vehículos.*/
    public void filtrarPorPrecioMenorAMil(){
        this.vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .map(vehiculo -> "Marca: " + vehiculo.getMarca() + ", Modelo: " + vehiculo.getModelo()  +
                        " - Costo: $" + vehiculo.getCosto())
                .forEach(System.out::println);
    }

    public void filtrarPorPrecioMayorOIgualAMil(){
        this.vehiculos.stream()
                .filter(vehiculo ->  vehiculo.getCosto() >= 1000)
                .map(vehiculo -> "Marca: " + vehiculo.getMarca() + ", Modelo: " + vehiculo.getModelo()  +
                        " - Costo: $" + vehiculo.getCosto())
                .forEach(System.out::println);
    }

    public Double obtenerPromedioTotalDePrecios(){
       return this.vehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);
    }
}
