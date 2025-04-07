package com.mercadolibre.Dakar.resources.modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrera<T extends Vehiculo> {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<T> vehiculos;
    private Socorrista<Auto> socorristaAuto;
    private Socorrista<Moto> socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new Socorrista<>();
        this.socorristaMoto = new Socorrista<>();
    }

    public void darDeAltaVehiculo(T vehiculo) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            vehiculos.add(vehiculo);
        }
    }

    public void eliminarVehiculo(T vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente));
    }

    public T definirGanador() {
        return vehiculos.stream().max((v1, v2) -> Double.compare(
                v1.getVelocidad() * 0.5 * v1.getAceleracion() / (v1.getAnguloDeGiro() * (v1.getPeso() - v1.getRuedas() * 100)),
                v2.getVelocidad() * 0.5 * v2.getAceleracion() / (v2.getAnguloDeGiro() * (v2.getPeso() - v2.getRuedas() * 100))
        )).orElse(null);
    }

    public void socorrerAuto(String patente) {
        vehiculos.stream()
                .filter(vehiculo -> vehiculo instanceof Auto && vehiculo.getPatente().equals(patente))
                .findFirst()
                .ifPresent(vehiculo -> socorristaAuto.socorrer((Auto) vehiculo));
    }

    public void socorrerMoto(String patente) {
        vehiculos.stream()
                .filter(vehiculo -> vehiculo instanceof Moto && vehiculo.getPatente().equals(patente))
                .findFirst()
                .ifPresent(vehiculo -> socorristaMoto.socorrer((Moto) vehiculo));
    }
}