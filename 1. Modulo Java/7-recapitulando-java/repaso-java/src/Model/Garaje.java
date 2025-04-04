package Model;

import java.util.Comparator;
import java.util.List;

public class Garaje {
    private Integer id;
    private List<Vehiculo> vehiculos;

    public Garaje(Integer id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public List<Vehiculo> obtenerVehiculosOrdenadosPorPrecio() {
        List<Vehiculo> sortedList = this.vehiculos.stream().sorted(Comparator.comparingInt(Vehiculo::getCosto)).toList();
        sortedList.forEach(System.out::println);
        return sortedList;
    }

    public List<Vehiculo> obtenerVehiculosOrdenadosPorMarcaYPrecio() {
        List<Vehiculo> sortedList = this.vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Comparator.comparingInt(Vehiculo::getCosto))).toList();
        sortedList.forEach(System.out::println);
        return sortedList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
