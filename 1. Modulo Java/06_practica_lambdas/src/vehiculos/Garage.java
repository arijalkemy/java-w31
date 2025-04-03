package vehiculos;

import java.util.List;

public class Garage {
    int id;
    List<Vehiculo> vehiculos;

    public Garage(int id, List<Vehiculo> vehiculo){
        this.id = id;
        this.vehiculos = vehiculo;
    }

}
