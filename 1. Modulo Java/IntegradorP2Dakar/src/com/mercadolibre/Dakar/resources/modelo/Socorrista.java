package com.mercadolibre.Dakar.resources.modelo;

public class Socorrista<T extends Vehiculo> {
    public void socorrer(T vehiculo) {
        System.out.println("Socorriendo " + vehiculo.getClass().getSimpleName().toLowerCase() + " " + vehiculo.getPatente());
    }
}