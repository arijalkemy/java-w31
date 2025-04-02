package ejercicio_vehiculos;

import java.util.ArrayList;

public class Garaje {
    private Integer id;
    private ArrayList<Vehiculo> vehiculos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Garaje(Integer id) {
        this.id = id;
        this.vehiculos = new ArrayList<Vehiculo>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    public void ordenarMenorAMayorPrecio() {
        vehiculos.stream().sorted((x, y) -> x.getCosto().compareTo(y.getCosto())).forEach(System.out::println);
    }

    public void ordenarMarcaYPrecio() {
        vehiculos.stream().sorted((x, y) -> {
            int marcaComparison = x.getMarca().compareTo(y.getMarca());
            if (marcaComparison != 0) {
                return marcaComparison;
            } else {
                return x.getCosto().compareTo(y.getCosto());
            }
        }).forEach(System.out::println);
    }

    public void precioMenorMil() {
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() < 1000).forEach(System.out::println);
    }

    public void precioMayorIgualMil() {
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).forEach(System.out::println);
    }

    public Double promedioPrecios() {
        return vehiculos.stream().mapToDouble(vehiculo -> vehiculo.getCosto()).average().getAsDouble();
    }

}
