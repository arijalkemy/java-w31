import java.util.ArrayList;

public class Garaje {
    private int id;
    private ArrayList<Vehiculo> vehiculos;

    public Garaje(int id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
