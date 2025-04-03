package com.mercadolibre.modulojava.dakar;

public class Moto extends Vehiculo {
    public Moto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.ruedas=2;
        this.peso=300D;
    }
}
