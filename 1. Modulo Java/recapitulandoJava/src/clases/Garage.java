package clases;

import java.util.List;

public class Garage {
    int id;
    List<Vehiculo> vehiculos;

    public Garage(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

}
