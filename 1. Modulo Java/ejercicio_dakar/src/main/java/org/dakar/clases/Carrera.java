package org.dakar.clases;

import java.util.List;

public class Carrera {
    private Integer distancia;
    private Integer premioEnDolares;
    private String nombre;
    private Integer cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculosList;

    public Carrera() {
    }

    public Carrera(Integer distancia, Integer premioEnDolares, String nombre, Integer cantidadVehiculosPermitidos, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.vehiculosList = vehiculos;
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if(vehiculosList.size() < cantidadVehiculosPermitidos) {
            vehiculosList.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        } else {
            System.out.println("No se admiten más vehiculos");
        }
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double AnguloDeGiro, String patente) {
        if (vehiculosList.size() < cantidadVehiculosPermitidos) {
            vehiculosList.add(new Moto(velocidad, aceleracion, AnguloDeGiro, patente));
        } else {
            System.out.println("No se admiten más vehiculos");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculosList.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        vehiculosList.removeIf(v -> v.getPatente().equals(unaPatente));
    }

    public void ganadorDeCarrera(){
        Vehiculo vehiculoGanador = new Vehiculo();
        double maxValor = 0D;

        if(vehiculosList.isEmpty()) {
            System.out.println("No hay vehiculos");
            return;
        };

        for (Vehiculo vehiculo : vehiculosList) {
            Double velocidad = vehiculo.getVelocidad();
            Double aceleracion = vehiculo.getAceleracion();
            Double anguloDeGiro = vehiculo.getAnguloDeGiro();
            Integer peso = vehiculo.getPeso();
            Integer cantidadRuedas = vehiculo.getRuedas();

            double valor = (velocidad * 0.5 * aceleracion) / (anguloDeGiro * (peso - cantidadRuedas * 100));
            if (valor > maxValor) {
                maxValor = valor;
                vehiculoGanador = vehiculo;
            }
        }

         System.out.println("El ganador del vehiculo es " + vehiculoGanador.getPatente());
    }
}

