package org.vehiculo.clases;

import java.util.List;

public class Garaje {
    private int id;
    private List<Vehiculo> vehiculosList;

    public Garaje(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculosList = vehiculos;
    }

    public List<Vehiculo> getVehiculosList() {
        return vehiculosList;
    }

    public void setVehiculosList(List<Vehiculo> vehiculosList) {
        this.vehiculosList = vehiculosList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}