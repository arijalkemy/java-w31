package com.company;

public class ReservaTransporte implements Reserva{
    private Double precio;

    public ReservaTransporte(Double precio) {
        this.precio = precio;
    }

    @Override
    public Double precio() {
        return this.precio;
    }

    @Override
    public String tipo() {
        return "Boleto";
    }
}
