package com.company;

public class ReservaComida implements Reserva{
    private Double precio;
    private String tipo;

    public ReservaComida(Double precio) {
        this.precio = precio;
        this.tipo = "Comida";
    }

    @Override
    public Double precio() {
        return this.precio;
    }

    @Override
    public String tipo() {
        return "Comida";
    }
    public String toString(){
        return "Tipo de Reserva: " + this.tipo + " Valor: " + this.precio;
    }
}
