import java.util.List;

public class Garaje {
    private static int generatedId;
    private int id;
    private List<Vehiculo> vehiculos;

    public Garaje(List<Vehiculo> vehiculos) {
        this.id = ++generatedId;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
