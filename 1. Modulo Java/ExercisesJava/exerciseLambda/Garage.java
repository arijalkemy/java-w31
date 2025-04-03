package exerciseLambda;

import java.util.List;

public class Garage {
    private Integer id;
    List<Vehiculo> listaVehiculos;

    public Garage(Integer id, List<Vehiculo> listaVehiculos) {
        this.id = id;
        this.listaVehiculos = listaVehiculos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public void addListVehiculos(Vehiculo vehiculo) {
        this.listaVehiculos.add(vehiculo);
    }

}
