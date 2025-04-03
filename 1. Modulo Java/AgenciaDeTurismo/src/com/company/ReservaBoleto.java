package com.company;

public class ReservaBoleto implements Reserva{
    private Double precio;
    private String tipo;

    public ReservaBoleto(Double precio) {
        this.precio = precio;
        this.tipo = "Boleto";
    }

    @Override
    public Double precio() {
        return this.precio;
    }

    @Override
    public String tipo() {
        return "Boleto";
    }

    public String toString(){
        return "Tipo de Reserva: " + this.tipo + " Valor: " + this.precio;
    }
}
