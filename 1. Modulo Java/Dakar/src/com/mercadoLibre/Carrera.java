package com.mercadoLibre;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia, premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> participantes = new ArrayList<>();
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (participantes.size() < cantidadDeVehiculosPermitidos) {
            participantes.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
            System.out.println("Auto inscripto exitosamente!");
        } else {
            System.out.println("No hay más cupo :(");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (participantes.size() < cantidadDeVehiculosPermitidos) {
            participantes.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
            System.out.println("Moto inscripta exitosamente!");
        } else {
            System.out.println("No hay más cupo :(");
        }
    }

    public void darDeBaja(Vehiculo vehiculo) {
        if (participantes.contains(vehiculo)) {
            participantes.remove(vehiculo);
            System.out.println("Vehículo eliminado correctamente.");
        } else {
            System.out.println("El vehículo no está en la lista");
        }
    }

    public void darDeBajaConPatente(String patente) {
        boolean eliminado = participantes.removeIf(v -> v.getPatente().equalsIgnoreCase(patente));
        if (eliminado) {
            System.out.println("Vehículo con patente " + patente + " eliminado.");
        } else {
            System.out.println("El vehículo con patente " + patente + " no está en la lista.");
        }
    }

    public Vehiculo ganador() {
        return participantes.stream()
                .max((v1, v2) -> {
                    double valor1 = v1.getVelocidad() * 0.5 * v1.getAceleracion() / (v1.getAnguloDeGiro() * (v1.getPeso() - v1.getRuedas() * 100));
                    double valor2 = v2.getVelocidad() * 0.5 * v2.getAceleracion() / (v2.getAnguloDeGiro() * (v2.getPeso() - v2.getRuedas() * 100));
                    return Double.compare(valor1, valor2);
                })
                .orElse(null);
    }

    public void socorrerAuto(String patente) {
        for (Vehiculo v : participantes) {
            if (v instanceof Auto && v.getPatente().equalsIgnoreCase(patente)) {
                socorristaAuto.socorrer((Auto) v);
                return;
            }
        }
        System.out.println("Auto con patente " + patente + " no encontrado.");
    }

    public void socorrerMoto(String patente) {
        for (Vehiculo v : participantes) {
            if (v instanceof Moto && v.getPatente().equalsIgnoreCase(patente)) {
                socorristaMoto.socorrer((Moto) v);
                return;
            }
        }
        System.out.println("Moto con patente " + patente + " no encontrada.");
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Vehiculo> participantes) {
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", participantes=" + participantes +
                '}';
    }
}
