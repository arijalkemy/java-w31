package com.mercadolimbre.modulojava.agenciadeturismo;

public class ReservaBoleto extends Reserva {
    public ReservaBoleto(double precio) {
        super(precio);
    }

    public String getTipo() {
        return "boleto";
    }

    @Override
    public String toString() {
        return "Reserva Boleto{" +
                "precio=" + this.getPrecio() +
                '}';
    }
}

