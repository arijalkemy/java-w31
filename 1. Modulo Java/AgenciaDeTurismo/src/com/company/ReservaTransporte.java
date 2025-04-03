package com.company;

public class ReservaTransporte implements Reserva{
    private Double precio;
    private String tipo;

    public ReservaTransporte(Double precio) {
        this.precio = precio;
        this.tipo = "Transporte";
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
