package com.mercadolibre;

import java.util.LinkedList;
import java.util.List;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;
    List<Vehiculo> vehiculos = new LinkedList<>();

    public Carrera(Double distancia, Double premioEnDolares, String nombre,
                   Integer cantidadDeVehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
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

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        Vehiculo auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        if (this.vehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            this.vehiculos.add(auto);
            System.out.println("Se agregó el auto a la carrera!");
        }
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        Vehiculo moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        if (this.vehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            this.vehiculos.add(moto);
            System.out.println("Se agregó la moto a la carrera!");
        }
    }

    public void eliminarVehiculo (Vehiculo vehiculo){
        this.vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
        Vehiculo vehiculo = this.vehiculos.stream().filter(v -> v.getPatente().equals(patente))
                            .findFirst().orElse(null);
        this.vehiculos.remove(vehiculo);
    }

    /* 6. Queremos poder definir el ganador de una carrera:
    El ganador será aquel que tenga el máximo valor determinado por la siguiente fórmula:
    Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)*/

    public void vehiculoGanador(){
        if (this.vehiculos.isEmpty()) {
            System.out.println("No hay vehículos en la carrera.");
            return;
        }

        Vehiculo ganador = null;
        double maxPuntaje = Double.MIN_VALUE; // Valor mínimo inicial

        for (Vehiculo v : this.vehiculos) {
            double puntaje = (v.getVelocidad() * 0.5 * v.getAceleracion()) /
                    (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100));

            if (puntaje > maxPuntaje) {
                maxPuntaje = puntaje;
                ganador = v;
            }
        }

            System.out.println("El vehiculo ganador es el de la patente: " + ganador.getPatente() +
                    " con un puntaje de: " + maxPuntaje);
        }


        public void socorrerAuto(String patente){
            Auto auto = (Auto) this.vehiculos.stream().filter(v -> v instanceof Auto && patente.equals(v.getPatente()))
                    .findFirst()
                    .orElse(null);
            if (auto != null) {
                this.socorristaAuto.socorrerAuto(auto);
            } else {
                System.out.println("No se encontró un auto con la patente: " + patente);
            }

        }

    public void socorrerMoto(String patente){
        Moto moto = (Moto) this.vehiculos.stream().filter(v -> v instanceof Moto && patente.equals(v.getPatente()))
                .findFirst()
                .orElse(null);
        if (moto != null) {
            this.socorristaMoto.socorrerMoto(moto);
        } else {
            System.out.println("No se encontró un auto con la patente: " + patente);
        }

    }
}