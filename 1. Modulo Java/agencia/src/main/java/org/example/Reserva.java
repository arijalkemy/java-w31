package org.example;

public class Reserva {
    private String tipo; // hotel, comida, boleto, transporte
    private double precio;

    public Reserva(String tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return tipo + " ($" + precio + ")";
    }
}

