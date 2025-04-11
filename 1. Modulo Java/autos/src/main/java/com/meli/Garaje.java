package com.meli;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;


public class Garaje {
    private int idVehiculo;
    private List<Vehiculo> vehiculos;

    public Garaje(int idVehiculo) {
        this.idVehiculo = idVehiculo;
        this.vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo v){
        vehiculos.add (v);
    }

    public void ordernarPorPrecio(){
        vehiculos.sort(Comparator.comparingDouble(Vehiculo::getCosto)); 
    }
    
    public void mostrarVehiculos() {
        for (Vehiculo v : vehiculos) {
            System.out.println(v);
        }
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

}