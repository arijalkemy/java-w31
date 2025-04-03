package Practica6;

import Practica6.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Garage {
    private String id;
    private List<Vehiculo> vehiculos;

    public Garage(String id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id='" + id + '\'' +
                ", vehiculos=" + vehiculos +
                '}';
    }


    public void ordenarPorMarca(){
        vehiculos.sort(Comparator.comparing( (v -> v.getMarca())));
    }

    public void ordenarPorCosto(){
        vehiculos.sort(Comparator.comparing(v -> v.getCosto()));
    }

    public void ordenarPorModelo(){
        vehiculos.sort(Comparator.comparing((v -> v.getModelo())));
    }

    public void ordenarPorMarcayCosto(){
        System.out.println(vehiculos);
        vehiculos.sort( Comparator.comparing((Vehiculo v) -> v.getMarca())
                .thenComparing(v -> v.getCosto())
        );
        System.out.println(vehiculos);
    }

    public Stream obtenerVehiculosPorPrecioMax(int maxPrecio) {
        return vehiculos.stream()
                .filter(v -> v.getCosto() <= maxPrecio);
    }

    public Stream obtenerVehiculosPorPrecioMin(int minPrecio) {
        return vehiculos.stream()
                .filter(v -> v.getCosto() >= minPrecio);
    }

    public double obtenerPromedioPrecio() {
        return vehiculos.stream()
                .mapToInt(Vehiculo::getCosto)
                .average()
                .orElse(0.0);
    }





}
