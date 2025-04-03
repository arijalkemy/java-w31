package com.company;

public class ReservaHotel implements Reserva{
    private Double precio;

    public ReservaHotel(Double precio) {
        this.precio = precio;
    }

    @Override
    public Double precio() {
        return this.precio;
    }

    @Override
    public String tipo() {
        return "Hotel";
    }
}
