package com.company;

public class ReservaBoleto implements Reserva{
    private Double precio;

    public ReservaBoleto(Double precio) {
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
