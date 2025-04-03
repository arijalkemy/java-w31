package com.mercadolibre.modulojava.dakar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos = new ArrayList<>();
    private SocorristaAuto socorristaAuto=new SocorristaAuto();
    private SocorristaMoto socorristaMoto=new SocorristaMoto();

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }


    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);

    }
    public void eliminarVehiculoConPatente(String unaPatente){
        vehiculos=vehiculos.stream().filter(vehiculo -> !Objects.equals(vehiculo.getPatente(), unaPatente)).toList();
    }
    public Vehiculo definirGanador(){
        Vehiculo ganador=vehiculos.getFirst();
        for (Vehiculo vehiculo : vehiculos) {
            if(vehiculo.formula()>ganador.formula()){
                ganador=vehiculo;
            }



        }
        return ganador;

    }
    public void socorrerAuto(String patente){
        vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).map(vehiculo -> (Auto)vehiculo).forEach(vehiculo -> {socorristaAuto.socorrer(vehiculo);});

    }
    public void socorrerMoto(String patente){
        vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).map(vehiculo -> (Moto)vehiculo).forEach(vehiculo -> {socorristaMoto.socorrer(vehiculo);});

    }
}