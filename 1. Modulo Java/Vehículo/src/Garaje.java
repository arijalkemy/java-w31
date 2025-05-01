import java.util.ArrayList;
import java.util.List;

public class Garaje {
   private int id;
    private List<Vehiculo> vehiculos;

    public Garaje(int id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}
