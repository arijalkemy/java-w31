import java.util.ArrayList;
import java.util.List;

public class Garage {
    private String id;
    private List<Vehicle> vehicles = new ArrayList<Vehicle>();

    public Garage(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }
}
