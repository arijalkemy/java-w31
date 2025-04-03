package exerciseIntegrator2.exercise2.clases;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    List<Vehiculo> listaVehiculos = new ArrayList<>();

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos,
            List<Vehiculo> listaVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaVehiculos = listaVehiculos;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    @Override
    public String toString() {
        String datosCarrera = "Carrera [distancia=" + distancia + ", premioEnDolares=" + premioEnDolares + ", nombre=" + nombre
                + ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos + "]";

        listaVehiculos.forEach(System.out::println);

        return datosCarrera;
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double AnguloDeGiro, String patente) {
        if (listaVehiculos.size() != this.cantidadDeVehiculosPermitidos) {
            listaVehiculos.add(new Autos(velocidad, aceleracion, AnguloDeGiro, patente, 1000D, 4));
        }
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double AnguloDeGiro, String patente) {
        if (listaVehiculos.size() != this.cantidadDeVehiculosPermitidos) {
            listaVehiculos.add(new Motos(velocidad, aceleracion, AnguloDeGiro, patente, 300D, 2));

        }
    }

    public void eliminarVehiculo(Vehiculo vehículo) {
        listaVehiculos.remove(vehículo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        listaVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente));
    }

    public Vehiculo obtenerVehiculoGanador() {
        return listaVehiculos.stream().max(Comparator.comparing(
                vehiculo -> (vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion()) / (vehiculo.getAnguloDeGiro()
                        * ((vehiculo.getPeso() - vehiculo.getRuedas()) * 100))))
                .orElse(null);
    }

    public void socorrerAuto(String patente){
        listaVehiculos.stream().filter((auto)-> auto.getPatente().
        equals(patente)).findFirst().orElse(null);
    }

     public void socorrerMoto(String patente) {
        listaVehiculos.stream().filter((auto)-> auto.getPatente().
        equals(patente)).findFirst().orElse(null);
        }


}
