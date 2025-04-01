package ejercicioGenerics;

import java.util.List;

public class Garaje {
    private int idGaraje;
    private List<Vehiculo> vehiculos;

    public Garaje(int idGaraje, List<Vehiculo> vehiculos) {
        this.idGaraje = idGaraje;
        this.vehiculos = vehiculos;
    }

    public int getIdGaraje() {
        return idGaraje;
    }

    public void setIdGaraje(int idGaraje) {
        this.idGaraje = idGaraje;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void addVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    public void showVehiculos() {
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
        }
    }

}


