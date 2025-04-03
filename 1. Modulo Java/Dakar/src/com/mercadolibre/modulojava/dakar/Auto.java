package com.mercadolibre.modulojava.dakar;

public class Auto extends Vehiculo{

    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {

        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.ruedas=4;
        this.peso=1000D;
    }

}
