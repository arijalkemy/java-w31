package com.mercadolimbre.modulojava.agenciadeturismo;

public abstract class Reserva {
    private double precio;

    public Reserva(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public abstract String getTipo();


}
