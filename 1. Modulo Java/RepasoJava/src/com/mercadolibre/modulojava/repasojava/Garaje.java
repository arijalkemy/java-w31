package com.mercadolibre.modulojava.repasojava;

import java.util.ArrayList;
import java.util.*;

public class Garaje {
    private String id;
    private List<Vehiculo> vehiculos=new ArrayList<>();
    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }
    public Garaje(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
