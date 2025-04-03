package com.mercadolibre.bootcamp.model;

public class Moto extends Vehiculo {


    public Moto(Double velocidad, Double aceleración, Double anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente, 300D, 2);
    }
}
