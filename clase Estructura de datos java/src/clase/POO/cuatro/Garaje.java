package clase.POO.cuatro;

import java.util.List;

public class Garaje {
    private List<Vehiculo> listaVehiculos;

    public Garaje(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }
}
