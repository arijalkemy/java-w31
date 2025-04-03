package com.mercadolibre.bootcamp.model;

public class Auto extends Vehiculo {

    public Auto(Double velocidad, Double aceleración, Double anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente, 1000D, 4);
    }
}
