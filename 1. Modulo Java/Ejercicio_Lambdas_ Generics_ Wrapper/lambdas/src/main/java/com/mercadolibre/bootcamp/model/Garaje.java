package com.mercadolibre.bootcamp.model;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private static int contador = 0;
    private int id;
    private List<Vehiculo> vehiculos;

    public Garaje() {
        this.id = ++Garaje.contador;
        this.vehiculos = new ArrayList<>();
    }

    public boolean addVehiculo(Vehiculo vehiculo) {
        return this.vehiculos.add(vehiculo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void mostrarVehiculos() {
        vehiculos.forEach(vehiculo -> System.out.println(vehiculo.toString()));
    }

}
