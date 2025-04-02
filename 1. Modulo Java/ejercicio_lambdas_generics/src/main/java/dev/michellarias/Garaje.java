package dev.michellarias;

import java.util.ArrayList;

public class Garaje {

    private int id;
    private ArrayList<Vehiculo> vehiculos;


    public Garaje(int id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Garaje addVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        return this;
    }

    public void imprimirVehiculos() {
        vehiculos.forEach(System.out::println);
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

}
