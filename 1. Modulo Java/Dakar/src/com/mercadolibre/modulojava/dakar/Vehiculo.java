package com.mercadolibre.modulojava.dakar;

public class Vehiculo {
        private Double velocidad;
        private Double aceleracion;
        private Double anguloDeGiro;
        private String patente;
        protected Double peso;
        protected Integer ruedas;

    public Vehiculo(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;


    }

    public String getPatente() {
        return patente;
    }
    public Double formula() {
        return (velocidad*(aceleracion*0.5))/(anguloDeGiro*(peso-(ruedas*100)));
    }
}
