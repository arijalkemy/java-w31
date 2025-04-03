package com.company;

public class ReservaComida implements Reserva{
    private Double precio;

    public ReservaComida(Double precio) {
        this.precio = precio;
    }

    @Override
    public Double precio() {
        return this.precio;
    }

    @Override
    public String tipo() {
        return "Comida";
    }
}
