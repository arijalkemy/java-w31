package org.example.model;

public abstract class Reserva {
    private Double precio;

    public Reserva(Double precio) {
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
