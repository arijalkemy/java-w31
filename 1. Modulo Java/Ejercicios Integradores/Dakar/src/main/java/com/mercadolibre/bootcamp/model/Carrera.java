package com.mercadolibre.bootcamp.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Carrera {

    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private Socorrista socorristaAuto;
    private Socorrista socorristaMotorista;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMotorista = new SocorristaMoto();
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion,Double aguloDeGiro, String patente) throws Exception {
        if(vehiculos.size() < cantidadVehiculosPermitidos){
            Moto moto = new Moto(velocidad, aceleracion, aguloDeGiro, patente);
            vehiculos.add(moto);
        }else{
            throw new Exception("Maxima cantidad de vehiculos permitidos excedido");
        }
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion,Double aguloDeGiro, String patente) throws Exception {
        if(vehiculos.size() < cantidadVehiculosPermitidos){
            Auto moto = new Auto(velocidad, aceleracion, aguloDeGiro, patente);
            vehiculos.add(moto);
        }else{
            throw new Exception("Maxima cantidad de vehiculos permitidos excedido");
        }
    }

    public void eliminarVehiculo(Vehiculo vehículo){
        this.vehiculos.remove(vehículo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente));
    }

    public Vehiculo obtenerVehiculoGanador(){
        return vehiculos.stream()
                .max(Comparator.comparing(vehiculo ->
                        (vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleración()) /
                                (vehiculo.getAnguloDeGiro() * ((vehiculo.getPeso() - vehiculo.getRuedas()) * 100))
                ))
                .orElse(null);
    }

    public void socorrerAuto(String patente){
        Vehiculo vehiculo = vehiculos.stream()
                .filter(v -> v.getPatente().equals(patente))
                .findFirst()
                .orElse(null);
        if (vehiculo != null) {
            this.socorristaAuto.socorrer(vehiculo);
        } else {
            System.out.println("No se encontró un vehículo con la patente: " + patente);
        }
    }

    public void socorrerMoto(String patente){
        Vehiculo vehiculo = vehiculos.stream()
                .filter(v -> v.getPatente().equals(patente))
                .findFirst()
                .orElse(null);
        if (vehiculo != null) {
            this.socorristaMotorista.socorrer(vehiculo);
        } else {
            System.out.println("No se encontró un vehículo con la patente: " + patente);
        }
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

    public Integer getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(Integer cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadVehiculosPermitidos=" + cantidadVehiculosPermitidos +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
