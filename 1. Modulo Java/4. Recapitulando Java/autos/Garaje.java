package autos;

import java.util.ArrayList;

public class Garaje {

    private final int id;
    private final ArrayList<Vehiculo> vehiculos;

    public Garaje(int id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void mostrarVehiculos() {
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println("Marca: " + vehiculo.getMarca() + ", Modelo: " + vehiculo.getModelo() + ", Costo: " + vehiculo.getCosto());
        }
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public int getId() {
        return id;
    }

}
