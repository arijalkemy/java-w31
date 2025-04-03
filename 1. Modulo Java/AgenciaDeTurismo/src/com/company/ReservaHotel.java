package com.company;

public class ReservaHotel implements Reserva{
    private Double precio;
    private String tipo;

    public ReservaHotel(Double precio) {
        this.precio = precio;
        this.tipo = "Hotel";
    }

    @Override
    public Double precio() {
        return this.precio;
    }

    @Override
    public String tipo() {
        return "Hotel";
    }

    public String toString(){
        return "Tipo de Reserva: " + this.tipo + " Valor: " + this.precio;
    }
}
