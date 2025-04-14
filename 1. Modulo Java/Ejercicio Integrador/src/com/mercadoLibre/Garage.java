package com.mercadoLibre;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Garage {
    private String id;
    private List<Vehiculo> listaVehiculos;

    public Garage() {
        listaVehiculos = new ArrayList<>();
    }

    public Garage(String id, List<Vehiculo> listaVehiculos) {
        this.id = id;
        this.listaVehiculos = listaVehiculos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        listaVehiculos.add(vehiculo);
    }

    public void mostrarVehiculos() {

        System.out.println("Lista de vehiculos");

        listaVehiculos.forEach(v -> System.out.println(v));

    }

    public void ordenarMenorMayorPrecio() {
        System.out.println("Listado por menor a mayor precio");

        listaVehiculos.sort(Comparator.comparingDouble(Vehiculo::getCosto)
                .thenComparing(Vehiculo::getMarca)
                .thenComparing(Vehiculo::getModelo));

        System.out.println(listaVehiculos);
    }


    public void ordenarMarca() {
        System.out.println("Listado por marca");

        listaVehiculos.sort(Comparator.comparing(Vehiculo::getMarca)
                .thenComparingDouble(Vehiculo::getCosto));

        System.out.println(listaVehiculos);
    }

    public void listadosPromedio() {

        List<Vehiculo> menoresMil = listaVehiculos.stream()
                .filter(v -> v.getCosto() < 1000)
                .collect(Collectors.toList());

        List<Vehiculo> mayoresMil = listaVehiculos.stream()
                .filter(v -> v.getCosto() >= 1000)
                .collect(Collectors.toList());

        double promedioMenores = menoresMil.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);

        double promedioMayores = mayoresMil.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);

        double promedioTotal = listaVehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);

        System.out.println("Listado de autos con precio no mayor a 1000" + menoresMil);
        System.out.println("Promedio de vehículos menores a 1000: " + promedioMenores);
        System.out.println("Listado de autos con precio igual o mayor a 1000" + promedioMayores);
        System.out.println("Promedio de vehículos mayores o iguales a 1000: " + promedioMayores);
        System.out.println("Promedio total de vehículos: " + promedioTotal);

    }

}
